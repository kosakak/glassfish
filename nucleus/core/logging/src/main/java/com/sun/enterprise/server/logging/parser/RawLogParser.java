/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.enterprise.server.logging.parser;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author sandeep.shrivastava
 */
public class RawLogParser implements LogParser {

    @Override
    public void parseLog(BufferedReader reader, LogParserListener listener) throws LogParserException {
        String line = null;
        try {
            long position = 0L;
            while ((line = reader.readLine()) != null) {
                ParsedLogRecord record = new ParsedLogRecord(line);
                record.setMessage(line);
                listener.foundLogRecord(position, record);
                position++;
            }
        } catch (IOException e) {
            throw new LogParserException(line, e);
        }
    }
}
