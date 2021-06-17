@echo off

for /f "tokens=*" %%A in ('dir "Allreports" /AD /O-D /B') do (set recent=%%A & goto exit)

:exit
echo extent = %recent% >>env.property

@echo off &setlocal
set "string=%recent%"
for /f "tokens=1,2,3 delims=_" %%i in ("%string%") do set "variable1=%%i" &set "variable2=%%j" &set "variable3=%%k"
echo variable1 = %variable1% >>env.property
echo variable2 = %variable2% >>env.property
echo variable3 = %variable3% >>env.property
endlocal