# Program AB Terminal Interaction #

For chat mode or pattern suggestor mode, Program AB tries to determine which directory was modified last: aiml or aimlif.
If the files in aiml/ are newer, then it loads the bot from those files.
If aimlif/ is newer, it loads those.
(Be careful not to edit BOTH aiml and aimlif files before running AB)
Be sure to close the spreadsheet editor (Excel) if you use it to open any .csv files.

## Interactive commands: ##

### From chat mode: ###


| q |  quit without saving |
|:--|:---------------------|
| wq |  write AIML and AIMLIF (.csv) files and quit |
| ab |  Enter catgeory browser/pattern suggestor mde |

### Pattern suggestor (Category Browser) mode: ###

The Pattern Suggestor (Category Browser) feature of Program AB scans a large sample of conversation data from a file (currently set to c:/ab/data/sample.txt) and automatically looks for new patterns, from which the botmaster can quickly create new AIML categories.

Note: This data file is NOT provided with free Program AB.  You can create your own data file, or use the [AIML Superbot Development Kit](http://alicebot.org/superbot.html).

Note also: To experiment with the sample.txt file provided, create a new bot called (for example) blankbot, and create empty directories:
```
bots/blankbot/aiml
bots/blankbot/aimlif
bots/blankbot/sets
bots/blankbot/maps
bots/blankbot/config
```
You can train a blank bot with the pattern suggestor applied to sample.txt.

The sample.txt file provided is copied from [1000 Questions Every Mobile Assistant should be able to answer](http://www.answerdevices.com/index.php?/blog/2/entry-13-1000-questions-every-mobile-assistant-should-be-able-to-answer/).  The bot SUPER provided in bots/super already contains responses for most of the inputs in sample.txt.

The file sample.txt contains 1000 inputs, but a much larger sample is generally better.  In our tests we used a sample of 500,000 inputs. The file sample.txt should be pre-normalized to reduce the time to run the pattern suggestor algorithm.

See the companion document [AIML Category Browser - Pattern Suggestor](https://docs.google.com/document/d/1WJ3HsFR6k3Z8XdNVS9EownhIxoiUe7DbNZwNr7yVYc8/pub).


| q |  quit without saving files |
|:--|:---------------------------|
| wq |  write AIML and AIMLIF files and quit |
| `<Enter>` or skip |  skip this category        |
| d |  delete this pattern       |
| x |  create a category with `<sraix>` of the pattern - saved in sraix.aiml |
| p |  inappropriate content - creates a category with `<srai>FILTER INAPPROPRIATE</srai>` - saved in inappropriate.aiml  |
| f |  profanity - creates a category with `<srai>FILTER PROFANITY</srai>` - saved in profanity.aiml |
| i |  insult - creates a category with `<srai>FILTER INSULT</srai>` - saved in insult.aiml |

### Writing a template: ###

If the input to the Catgeory browser is not one of the commands listed above, then the response is taken to be a new AIML template.  You do not need to enter the `<template>` tag.

Program AB tries to guess a filename for your new category.

| **template conatins** | **category saved in** |
|:----------------------|:----------------------|
| `<srai>`              |reductions\_update.aiml |
| `<sraix>`             | sraix.aiml            |
| `<oob>`               | oob.aiml              |
| `<set name`           | client\_profile.aiml  |
| `<get name`  (except `<get name=”name”/>`)  | client\_profile.aiml  |
|  anything else        | personality.aiml      |

Optionally, you can write

```
<pattern>SOME PATTERN</pattern>  response
```

and it will create a category with pattern SOME PATTERN and template “response”.