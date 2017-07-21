/*
 * Copyright (c)  2017 Alen Turković <alturkovic@gmail.com>
 *
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.github.alturkovic.asn.ber.decoder;

import com.github.alturkovic.asn.ber.model.BerExampleProvider;
import com.github.alturkovic.asn.decoder.AsnDecoder;
import com.github.alturkovic.asn.ber.params.HexParam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BerDecoderTest {

    private final AsnDecoder<byte[]> decoder = new BerDecoderBuilder().build();

    @Test
    @TestCaseName("[{index}] decode: ({0})")
    @Parameters(source = BerExampleProvider.class)
    public void shouldDecode(final Object obj, @HexParam final byte[] ber) {
        final Object decoded = decoder.decode(obj.getClass(), ber);
        assertThat(decoded).isEqualTo(obj);
    }
}