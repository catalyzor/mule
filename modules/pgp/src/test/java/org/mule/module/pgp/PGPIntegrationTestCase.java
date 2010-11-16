/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.pgp;

import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;

public class PGPIntegrationTestCase extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "pgp-integration-mule-config.xml";
    }

    public void testEncryptDecrypt() throws Exception
    {
        String payload = "this is a simple test";
        MuleClient client = new MuleClient();
        client.send("vm://in", new DefaultMuleMessage(payload));
        MuleMessage message = client.request("vm://out", 10000);
        assertEquals(payload, message.getPayloadAsString());
    }
}