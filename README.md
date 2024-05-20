<div style="text-align:center;">
  <img src="https://th.bing.com/th/id/OIP.TazuYpGvMsCBSFeKw4QSDQHaHa?w=194&h=194&c=7&r=0&o=5&dpr=2&pid=1.7" alt="Coding" style="display:block; margin:auto;" width="400">
</div>

A Simulation of process scheduling in a bar scenario, where patrons arrive randomly and place drink orders.mplementations of both First Come First Served (FCFS) and Shortest Job First (SJF) scheduling algorithms. This project explores and compares the efficiency of scheduling algorithms(SJF and FCFS) in handling drink orders at the bar.

# Bar Scheduling Simulation

This repository contains a Java-based simulation of drink order scheduling at a bar. Different scheduling algorithms such as First-Come-First-Served (FCFS) and Shortest Job First (SJF) are implemented for comparison.

Author : Aphiwe Mkhwananazi 👨‍💻

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
