/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", "Jexl" and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.commons.jexl.util;

/**
 *  Coercion utilities for the JSTL EL-like coercion.
 *
 *  @author <a href="mailto:geirm@apache.org">Geir Magnusson Jr.</a>
 */
public class Coercion
{

    public static Boolean coerceBoolean(Object val)
        throws Exception
    {
        if (val == null)
        {
            return Boolean.FALSE;
        }
        else if (val instanceof Boolean)
        {
            return (Boolean) val;
        }
        else if (val instanceof String)
        {
            return Boolean.valueOf((String) val);
        }

        return null;
    }

    public static Integer coerceInteger(Object val)
        throws Exception
    {
        if (val == null)
        {
            return new Integer(0);
        }
        else if (val instanceof String)
        {
            if(((String)val).equals(""))
                return new Integer(0);

            return Integer.valueOf((String)val);
        }
        else if(val instanceof Character)
        {
            return new Integer((int)((Character)val).charValue());
        }
        else if(val instanceof Boolean)
        {
            throw new Exception("Boolean->Integer coercion exception");
        }
        else if(val instanceof Number)
        {
            return new Integer(((Number)val).intValue());
        }

        throw new Exception("Integer coercion exception");
    }

    public static Long coerceLong(Object val)
        throws Exception
    {
        if (val == null)
        {
            return new Long(0);
        }
        else if (val instanceof String)
        {
            if(((String)val).equals(""))
                return new Long(0);

            return Long.valueOf((String)val);
        }
        else if(val instanceof Character)
        {
            return new Long((long)((Character)val).charValue());
        }
        else if(val instanceof Boolean)
        {
            throw new Exception("Boolean->Integer coercion exception");
        }
        else if(val instanceof Number)
        {
            return new Long(((Number)val).longValue());
        }

        throw new Exception("Long coercion exception");
    }

    public static Double coerceDouble(Object val)
        throws Exception
    {
        if (val == null)
        {
            return new Double(0);
        }
        else if (val instanceof String && ((String)val).equals(""))
        {
            return new Double(0);
        }
        else if(val instanceof Character)
        {
            int i = ((Character)val).charValue();

            return new Double(Double.parseDouble(String.valueOf(i)));
        }
        else if(val instanceof Boolean)
        {
            throw new Exception("Boolean->Integer coercion exception");
        }
        else if(val instanceof Double)
        {
            return (Double) val;
        }
        else if (val instanceof Number)
        {
            return new Double(Double.parseDouble(String.valueOf(val)));
        }

        throw new Exception("Double coercion exception");
    }

}