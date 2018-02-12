/*
Copyright 2018 by Leipzig University Library, http://ub.uni-leipzig.de
                  The Finc Authors, http://finc.info
                  Martin Czygan, <martin.czygan@uni-leipzig.de>

This file is part of some open source application.

Some open source application is free software: you can redistribute
it and/or modify it under the terms of the GNU General Public
License as published by the Free Software Foundation, either
version 3 of the License, or (at your option) any later version.

Some open source application is distributed in the hope that it will
be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Foobar.  If not, see <http://www.gnu.org/licenses/>.

@license GPL-3.0+ <http://spdx.org/licenses/GPL-3.0+>
 */
package de.ubleipzig.finc.proplister;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Martin Czygan
 */
public class Main {

    /**
     * @param args Filename and optional encoding name.
     */
    public static void main(String[] args) throws Exception {
        switch (args.length) {
            case 1:
                loadPropertiesWithEncoding(args[0], "ISO-8859-1");
                break;
            case 2:
                loadPropertiesWithEncoding(args[0], args[1]);
                break;
            default:
                System.err.printf("Usage: %s FILE [ENCODING]\n", System.getProperty("sun.java.command"));
                break;
        }
    }

    /* Load properties file with a given encoding. */
    public static void loadPropertiesWithEncoding(String filename, String encoding) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis, encoding);
        Properties props = new Properties();
        props.load(isr);
        props.list(System.out);
    }

}
