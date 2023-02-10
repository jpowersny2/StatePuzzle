# StatePuzzle

This solves a state map puzzle. The challenge is to color a map of the United States' lower 48 states with one of four colors. Each color has a price per unit-squared. The idea is to paint the map such that no two borders share the same color while minimizing the cost of the entire map.

Price of each color:
  red=1  blue=2  green=3,  yellow=4
  
States have the following areas:
  AL=52   AZ=114   AR=53   CA=159   CO=104   CT=5
  DE=2    FL=59    GA=59   ID=84    IL=56    IN=36
  IA=56   KS=82    KY=40   LA=49    ME=33    MD=11
  MA=8    MI=58    MN=84   MS=48    MO=70    MT=147
  NE=77   NV=110   NH=9    NJ=8     MN=122   NY=50
  NC=53   ND=71    OH=41   OK=70    OR=97    PA=45
  RI=1    SC=31    SD=77   TN=42    TX=267   UT=85
  VT=10   VA=41    WA=68   WV=24    WI=56    WY=98
  
  Running:
  
  Before running the puzzle you must create a directory in your home directory
  named 'solutions'.
  
  Start the program on a command line: java StatePuzzle [threads] [firstjob]
  
  threads: default is 4 but can be any number. For fastest results, set this to the number
           of virtual cores you have available. I have run this on machines with between
           1 and 64 cores.
  
  firstjob: default is 0. If you specify a number between 0 and 4095, it will start with
            that job and eventually end at 4095. However, it will not include any job
            already completed, as recorded in lastjob.trk (see below).

Display:
The display is written for a VT100 terminal using control codes to rewrite
the screen. Therefore, it is written for with linux in mind, but otherwise will run
on any OS that support Java 11 and has a <home> directory property. 
The display will work properly in a Windows command shell if you run ansicon.exe first
(https://github.com/adoxa/ansicon/releases).

The columns are:

      Thread number: or execution slot. There will be a row for each of the threads specified on
                     the command line.
      Pecentage:     Approximately how complete each job is. This is calculated by using the color
                     number of states 6-10.
      Job number:    As an execution slot becomes available, a new job will slot it. The job number
                     is the first 6 states color minus 111111, base 4.
      Map string:    This is the color of each of the 48 states.

The display is updated after a thread has found 10 million legal maps.

Results:
Final and intermediate results are stored in the users <home>/solutions.
<number>.txt are some of the scores that were found. When the puzzle is
complete, the lowest numbered txt file is the solution. The highest will be the most "expensive"
and should have exactly the opposite colored states, red<->yellow, blue<->green.  
The <number>.txt files between the lowest and highest are just that, but they are by no means
a complete list. The files in between the highest and lowest may be discarded at any time.

  Theory of operation:
  There are 4^48 combinations of 4 colors on 48 states, including "illegal" combinations".
  The software solves this exhaustively through recursion. But once it finds two states 
  in an illegal position (shared boarder, same color) it does not traverse the tree any
  further, which cuts off a huge portion of the combinations, making the problem reasonable
  to solve. Still many branches remain to be scored. Expect the solution to take several day
  or more depending on your hardware.
  
  The problem is broken down into 4096 pieces by using a base 4 count of the first 6 states,
  which do not not share a border: TX, CA, MT, CO, VT, AL. The StateMap class assumes the first
  6 states do not share a boarder and does not evaluate that.
  
  <user>/solutions/lastjob.trk contains a list of all completed jobs. Jobs found in this file will
  not be evaluated when the program is run again.
  
  