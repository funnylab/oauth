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
import java.io.Writer; 

import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

public class NoEscapeHandler implements CharacterEscapeHandler { 

private NoEscapeHandler() { 
       super(); 
} 
public static final NoEscapeHandler theInstance = new NoEscapeHandler(); 
/** 
* Escape characters inside the buffer and send the output to the writer. 
* 
* @param buf buffer of characters to be encoded 
* @param start the index position of the first character that should be encoded 
* @param len the number of characters that should be encoded 
* @param isAttValue true, if the buffer represents an XML tag attribute 
* @param out the output stream 
* @throws IOException if the writing process fails 
*/ 
   public void escape(char[] buf, int start, int len, boolean isAttValue, Writer out) throws IOException { 
        for (int i = start; i < start + len; i++) { 
                  out.write(buf[i]); 
        } 
   return; 
   } 
} 