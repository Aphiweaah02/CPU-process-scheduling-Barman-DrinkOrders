JAVAC=/usr/bin/javac
.SUFFIXES: /java .class
SRCDIR=src/barScheduling
BINDIR=bin/barScheduling

# Define input arguments
ALGORITHM ?= 0  # Default value for algorithm (0 for FCFS and 1 for SJF)
NUM_PATRONS ?= 100  # Default value for number of patrons


$(BINDIR)/%.class:$(SRCDIR)/*.java
		$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $^

CLASSES= Patron.class Barman.class DrinkOrder.class SchedulingSimulation.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/SchedulingSimulation/*.class


run: $(CLASS_FILES)
	java -cp $(BINDIR) barScheduling.SchedulingSimulation $(ARGS)

ARGS = 100 0 #default
