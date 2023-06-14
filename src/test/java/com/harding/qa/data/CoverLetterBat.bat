@echo off
REM
REM Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
REM
REM Redistribution and use in source and binary forms, with or without
REM modification, are permitted provided that the following conditions
REM are met:
REM
REM   - Redistributions of source code must retain the above copyright
REM     notice, this list of conditions and the following disclaimer.
REM
REM   - Redistributions in binary form must reproduce the above copyright
REM     notice, this list of conditions and the following disclaimer in the
REM     documentation and/or other materials provided with the distribution.
REM
REM   - Neither the name of Oracle nor the names of its
REM     contributors may be used to endorse or promote products derived
REM     from this software without specific prior written permission.
REM
REM THIS
REM


jrunscript -J-Dcom.sun.management.jmxremote.port=1090 -J-Dcom.sun.management.jmxremote.ssl=false -J-Dcom.sun.management.jmxremote.authenticate=false memory.js

