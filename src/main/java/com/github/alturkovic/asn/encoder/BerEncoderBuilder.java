/*
 * MIT License
 *
 * Copyright (c) 2020 Alen Turkovic
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.github.alturkovic.asn.encoder;

import com.github.alturkovic.asn.AsnClassDescription;
import com.github.alturkovic.asn.converter.AsnConverter;
import com.github.alturkovic.asn.field.accessor.DirectFieldAccessor;
import com.github.alturkovic.asn.field.accessor.FieldAccessor;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BerEncoderBuilder {

  private FieldAccessor fieldAccessor = new DirectFieldAccessor();
  private Map<Class<?>, AsnClassDescription> classDescriptionCache = new HashMap<>();
  private Map<Class<? extends AsnConverter<byte[], Object>>, AsnConverter<byte[], Object>> converterCache = new HashMap<>();

  public BerEncoderBuilder fieldAccessor(final FieldAccessor fieldAccessor) {
    this.fieldAccessor = fieldAccessor;
    return this;
  }

  public BerEncoderBuilder classDescriptionCache(final Map<Class<?>, AsnClassDescription> classDescriptionCache) {
    this.classDescriptionCache = classDescriptionCache;
    return this;
  }

  public BerEncoderBuilder converterCache(final Map<Class<? extends AsnConverter<byte[], Object>>, AsnConverter<byte[], Object>> converterCache) {
    this.converterCache = converterCache;
    return this;
  }

  public BerEncoder build() {
    return new BerEncoder(fieldAccessor, classDescriptionCache, converterCache);
  }
}