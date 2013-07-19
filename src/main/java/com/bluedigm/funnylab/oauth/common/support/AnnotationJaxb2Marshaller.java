/*
 * Copyright (c) 2011 SK planet.
 * All right reserved.
 *
 * This software is the confidential and proprietary information of SK planet.
 * You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with SK planet.
 */
package com.bluedigm.funnylab.oauth.common.support;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.oxm.UncategorizedMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;


/**
 * An extension to the Jaxb2Marshaller that scans the classpath for classes annotated
 * with the @XmlRootElement (and others) annotation. I don't like typing in the class in
 * classesToBeBound since I often forget which ones I've done!
 */
/**
 * The Class AnnotationJaxb2Marshaller.
 * 
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 2. 14 오후 6:19:51
 * @version 1.0
 */
public class AnnotationJaxb2Marshaller extends Jaxb2Marshaller {

	/** The Constant RESOURCE_PATTERN. */
	private static final String RESOURCE_PATTERN = "/**/*.class";

	/** The packages to scan. */
	private String[] packagesToScan;

	/** The resource pattern resolver. */
	private final ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	public AnnotationJaxb2Marshaller() {
		super();
		CharacterEscapeHandler escapeHandler = NoEscapeHandler.theInstance;
		Map<String, CharacterEscapeHandler> map = new HashMap<String, CharacterEscapeHandler>();
		map.put("com.sun.xml.bind.characterEscapeHandler", escapeHandler);

		super.setMarshallerProperties(map);

	}

	/** The jaxb2 type filters. */
	private final TypeFilter[] jaxb2TypeFilters = new TypeFilter[] {
			new AnnotationTypeFilter(XmlRootElement.class, false), new AnnotationTypeFilter(XmlType.class, false),
			new AnnotationTypeFilter(XmlSeeAlso.class, false), new AnnotationTypeFilter(XmlEnum.class, false), };

	/**
	 * Scan packages looking for any classes annotated with the @XmlRootElement
	 * annotation.
	 * 
	 * @return the list
	 */
	protected List<Class<?>> scanPackages() {
		final List<Class<?>> annotatedClasses = new ArrayList<Class<?>>();
		try {
			if (packagesToScan != null) {
				for (final String pkg : packagesToScan) {
					final String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
							+ ClassUtils.convertClassNameToResourcePath(pkg) + RESOURCE_PATTERN;
					final Resource[] resources = resourcePatternResolver.getResources(pattern);
					final MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
							resourcePatternResolver);
					for (final Resource resource : resources) {
						final MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
						final String className = metadataReader.getClassMetadata().getClassName();
						if (matchesFilter(metadataReader, metadataReaderFactory)) {
							final Class<?> jaxb2AnnotatedClass = resourcePatternResolver.getClassLoader().loadClass(
									className);
							annotatedClasses.add(jaxb2AnnotatedClass);
						}
					}
				}
			}
		} catch (final IOException ex) {
			throw new UncategorizedMappingException("Failed to scan classpath for unlisted classes", ex);
		} catch (final ClassNotFoundException ex) {
			throw new UncategorizedMappingException("Failed to load annotated classes from classpath", ex);
		}
		return annotatedClasses;
	}

	/**
	 * Determine if any of the classes matches our list of acceptable
	 * annotations.
	 * 
	 * @param metadataReader for the resource.
	 * @param metadataReaderFactory for the resource.
	 * @return true if the class contains the annotation.
	 * @throws IOException if anything goes wrong.
	 */
	protected boolean matchesFilter(final MetadataReader metadataReader,
			final MetadataReaderFactory metadataReaderFactory) throws IOException {
		if (jaxb2TypeFilters != null) {
			for (final TypeFilter typeFilter : jaxb2TypeFilters) {
				if (typeFilter.match(metadataReader, metadataReaderFactory)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Why oh why is the afterPropertiesSet in the super class final???.
	 * 
	 * @return the jaxb context
	 */
	@Override
	public synchronized JAXBContext getJaxbContext() {

		// if ( packagesToScan.length > 0) {
		// // We will try *my* way :-)
		// final List<Class<?>> annotatedClasses = scanPackages();
		// if (annotatedClasses.size() > 0) {
		// setClassesToBeBound(annotatedClasses.toArray(new Class<?>[0]));
		// }
		// }
		return super.getJaxbContext();
	}

	/**
	 * Set packages to scan.
	 * 
	 * @param packagesToScan do'h.
	 */
	public void setPackagesToScan(final String[] packagesToScan) {
		Assert.notEmpty(packagesToScan, "'packagesToScan' must not be empty");
		this.packagesToScan = Arrays.copyOf(packagesToScan, packagesToScan.length);
		if (packagesToScan.length > 0) {
			// We will try *my* way :-)
			final List<Class<?>> annotatedClasses = scanPackages();
			if (annotatedClasses.size() > 0) {
				setClassesToBeBound(annotatedClasses.toArray(new Class<?>[0]));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.oxm.jaxb.Jaxb2Marshaller#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		if (!ObjectUtils.isEmpty(getClassesToBeBound())) {
			return Arrays.asList(getClassesToBeBound()).contains(clazz);
		}
		return false;
	}

}
