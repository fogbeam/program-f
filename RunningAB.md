# Program AB #

Program AB is a free reference implementation of AIML 2.0 provided by the ALICE A.I. Foundation.

# Download and Install #

Note: You must install Java first if you do not already have it installed.   See [Oracle Free Java Download](http://www.java.com/en/download/index.jsp).

Download the zip file under the "Download Program AB" link on the home page for this project.   You can download this file into any directory you wish, however for the purpose of this document we will assume you expand the .zip file into a directory called c:/ab.  If you are using a different root directory, replace c:/ab in the text below with your root directory.


When you expand the .zip file you should see the following directories and files:

| c:/ab/bots | the AIML bots go in this directory |
|:-----------|:-----------------------------------|
| c:/ab/lib  | Java libraries needed to run this code |
| c:/ab/out  | Java class file directory          |
| c:/ab/run.bat | batch file to run Program AB       |

Program AB comes with a sample bot called ALICE 2.0 found in the bots/alice2 directory.

# Bot directory structure #

The c:/ab/bots directory contains your AIML bots.  If you have a bot named **botname** then you should create the following directories:

| c:/ab/bots/botname/aiml | store your AIML files here |
|:------------------------|:---------------------------|
| c:/ab/bots/botname/aimlif | Program AB stores AIMLIF files here |
| c:/ab/bots/botname/config | Bot configuration files    |
| c:/ab/bots/botname/sets | AIML Sets                  |
| c:/ab/bots/botname/maps | AIML Maps                  |

For a sample AIML 2.0 bot configured for Program AB, see the companion project [S.U.P.E.R. AIML Bot](https://code.google.com/p/aiml-en-us-foundation-super/).

# Run Program AB #

## Windows ##

Modify the run.bat file for your needs.  Command line options are

| action=chat | run the bot and have a chat |
|:------------|:----------------------------|
| action=ab   | run the experimental pattern suggestor |
| action=csv2aiml | convert AIMLIF files to AIML |
| action=aiml2csv | convert AIML files to AIMLIF |
| bot=botname | run the bot found in the botname directory |
| trace=true  | print out useful tracing information |

## Mac or Linux ##

Same as Windows, but use run.sh instead of run.bat.