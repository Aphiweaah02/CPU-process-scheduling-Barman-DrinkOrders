
# Bar Scheduling Simulation

This repository contains a Java-based simulation of drink order scheduling at a bar. Different scheduling algorithms such as First-Come-First-Served (FCFS) and Shortest Job First (SJF) are implemented for comparison.

Author : Aphiwe Mkhwananazi MKHAPH002

- Java Development Kit (JDK) must be installed to be able to run the java program

Steps to run
1. compile the files by running 'make' in terminal
2. run the files by 'make run'

3. Run the simulation with your desired scheduling algorithm: FIRST ARGUMENT = noPatrons SECOND ARGUMENT = Algorithm
 1.open Terminal
 2. compile the makefile by using 'make' in the terminal
 3. choose scheduling algorithm by choosing a corresponding value(O=FCFS, 1=SJF)
 4. to run the file you have to supply to arguments "noPatrons ScheduleAlogorithm" or run default "100 0"
 5. to run the program use 'make run ARGS="noPatrons value"
 6. The program will create a new file named turnaround_time_0 if you are running FCFS and turnaround_time_1 if you are running SJF
4. After the simulation completes, check the output files for the results.

## Output Files
- The simulation generates txt file containing patron metrics for each run.
- the metric output is in this order (patronID,arrivalTime,totalPrepTime, turnaroundTime, waitingTime, responseTime)
- The last few lines at the bottom of patron output  noPatrons
Number of patrons
The number of drinks served
turnoverTime
average turnoverTime
waitingtime
average waitingtime
average waitingtime
- These files can be found in the `output` directory.
