@echo off

rem if we have already defined this environment, we can avoid adding this stuff to the path again

set JAVAVER=jdk1.8.0_51


set PROGx86=%ProgramFiles(x86)%
if "%PROGx86%" == "" set PROGx86=%ProgramFiles%
if "%PROGx86%" == "" (
    echo Can't find either "Program Files" or "Program Files (x86)" directory.
    goto end
)

set JAVADIR=%PROGx86%\Java\%JAVAVER%

:set_java_home
set JAVA_HOME=%JAVADIR%
@set JRE_HOME=%JAVA_HOME%\jre
echo JAVA_HOME set to %JAVA_HOME%
echo.

set GRADLE_HOME=C:\KBData\tmp\gradle-4.1
set GIT_HOME=C:\KBData\softwares\PortableGit-2.21.0-64-bit.7z\PortableGit
@rem devenv.com is under C:\Windows\Microsoft.NET\Framework\v4.0.30319

set PATH=%JAVA_HOME%\bin;%GRADLE_HOME%\bin;%GIT_HOME%\bin;%PATH%
echo Set up MSBuild and the following items have been prepended to PATH
@echo   DEVENV
@echo   VCBUILD
@echo   %GRADLE_HOME%
@echo   %GIT_HOME%


:end
