@echo off
set COMPCODE=%~1

%~d0
cd %~dp0

echo on
java -Dtalend.component.manager.m2.repository=../lib -Xms256M -Xmx1024M -cp .;../lib/routines.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/crypto-utils-7.1.16.jar;../lib/talend-proxy-1.0.2.jar;../lib/talend_file_enhanced-1.3.1.jar;../lib/audit-log4j2-1.16.1.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/json-smart-2.4.11.jar;../lib/logging-event-layout-1.16.1.jar;../lib/asm-9.5.jar;../lib/commons-lang3-3.10.jar;../lib/dom4j-2.1.3.jar;../lib/system-routines.jar;../lib/slf4j-api-1.7.34.jar;../lib/job-audit-1.5.jar;../lib/talendcsv-1.1.0.jar;../lib/audit-common-1.16.1.jar;../lib/accessors-smart-2.4.11.jar;testjob_withvar_0_1.jar; r01poctc01_test.testjob_withvar_0_1.TestJob_WithVar --context_param compcode=%COMPCODE% --log4jLevel=Info %*
