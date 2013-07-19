package com.bluedigm.funnylab.oauth.common.support;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;

/**
 * <pre>
 * com.skp.openplatform.core.framework.support
 *    |_ JaxbJacksonObjectMapper.java
 * JAXB Jacson Object Mapper Class
 * </pre>
 *
 * @author Han-Woong Lee, Bluedigm
 * @date 2012. 4. 26. 오후 2:44:56
 * @version 0.0.1
 */
public class JaxbJacksonObjectMapper extends ObjectMapper{
    /**
     * Annotation introspector to use for serialization process
     * is configured separately for serialization and deserialization purposes
     */

	public JaxbJacksonObjectMapper() {
                  final AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
                  super.getDeserializationConfig().withAnnotationIntrospector(introspector);
                  super.getSerializationConfig().withAnnotationIntrospector(introspector);
                  
                  super.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
                  super.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);

    }
}