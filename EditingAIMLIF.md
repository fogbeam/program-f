# AIML Intermediate Format #

The AIMLIF (AIML Intermediate Format) directory contains a parallel copy of the information stored in the AIML directory, in a spreadsheet format.  You can edit the CSV files in this directory using MS Excel, Google Docs, or any other spreadsheet editor capable of reading and writing CSV format.

AIMLIF translates each AIML category into a single line of text.   The lines consist of fields separated by a “,” character.   The order of the fields (or columns) is:

activation count, input pattern, that pattern, topic pattern, template, filename.

AIMLIF is not an XML format.  The fields for input pattern, that pattern and topic pattern do not contain the AIML tags `<pattern>`, `<that>` or `<topic>`.   The `<category>` tag is omitted as well.  This simplification helps make writing AIML more productive, saving you from typing these tags repeatedly.

The template column however does contain the AIML template in XML form.   AIML is a hybrid of spreadsheet-style data (the six columns activation count, input pattern, that pattern, topic pattern, template, filename) and hierarchical XML data in the template.

Let’s look at a couple of examples. This AIML category comes from the file reductions.aiml:

```
<category>
<pattern>DO YOU THINK YOU WILL *</pattern>
<template><srai>WILL YOU <star/></srai>
</template>
</category>
```

has an intermediate format representation

```
0,DO YOU THINK YOU WILL *,*,*,<srai>WILL YOU <star/></srai>,reductions.aiml
```

The activation count is 0.  The pattern is DO YOU THINK YOU WILL **.  Both the that pattern and topic pattern are**.   The template is `<srai>WILL YOU <star/></srai>`, and the filename is reductions.aiml.

If the file personality.aiml contains the category

```
<category><pattern>HI</pattern>
<template><random>
<li>Hi, nice to see you!</li>
<li>Hi it's great to see you!</li>
<li>Hi how are you?</li>
<li>Hi!  I can really feel your smile today.</li>
<li>Hi! It's delightful to see you.</li>
</random></template>
```

it will be represented in the AIMLIF file personality.aiml.csv as

```
0,HI,*,*,<random>#Newline<li>Hi#Comma nice to see you!</li>#Newline<li>Hi it's great to see you!</li>#Newline<li>Hi how are you?</li>#Newline<li>Hi!  I can really feel your smile today.</li>#Newline<li>Hi! It's delightful to see you.</li>#Newline</random>,personality.aiml
```

all on a single line.


## Special characters ##

Because the AIMLIF representation uses a comma to separate these fields, it is important to avoid using the “,” character in the AIML template.   (Note: “,” is not allowed in AIML pattern, that, topic or filename fields).  If you are editing the AIMLIF files, instead of writing “,” in a template, use the macro #Comma.

Because the AIMLIF representation uses only one line of text per category, it is also important to avoid newlines in the AIML template.  (Note: newline is not allowed in AIML pattern, that, topic or filename fields).  If you are editing the AIMLIF files, instead of entering a newline, use the macro #Newline.

The csv2aiml.bat program will convert the #Comma to “,” and the #Newline to a newline.  Conversely, the aiml2csv.bat program converts any “,” to #Comma and newline to #Newline.

## Activation count ##

The activation count column tells the number of times each category was activated in the sample data.  This data is not provided with Program AB.  A good strategy for modifying a bot is to work first on the categories with the highest activation count.   This will help distinguish your bot personality from other bots quickly.

## Filename ##

Each AIMLIF file contains a filename field.  Initially, this field value will be the same as the AIML file from which the AIMLIF file was translated.  You can change the filename value of any particular category in the AIMLIF file.  When you convert the CSV files back to AIML, the category will be saved in the filename specified by the last column value, no matter which AIMLIF file it came from.