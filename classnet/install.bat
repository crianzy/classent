echo off
rem 执行安装程序
java -classpath .;WebRoot/WEB-INF/classes/ com.czy.myclass.install.Installer
rem 暂停
pause
