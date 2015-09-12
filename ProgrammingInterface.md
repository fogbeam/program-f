# Link to Ab.jar #

Add the Ab.jar library to your application.  In your Java files,
use

```
import org.alicebot.ab.*;
```


# Create a bot #

Create a bot with

```
String botname="mybot";
Bot bot = new Bot(botname);
```

You can also specify a root path for the bot's files with

```
String botname="mybot";
String path="c:/example";
Bot bot = new Bot(botname, path);
```

If the Program AB bot files are in a directory c:/example then a bot named named **mybot** should use the directories:

| Directory | Contents |
|:----------|:---------|
| c:/example/bots/mybot/aiml | AIML Files |
| c:/example/bots/mybot/aimlif | AIMLIF format files |
| c:/example/bots/mybot/config | Bot configuration Files |
| c:/example/bots/mybot/sets | AIML Sets |
| c:/example/bots/mybot/maps | AIML Maps |

The constructor method will load all the bot's categories, substitutions, configuration files, and set and map definitions.

# Create a chat session #

Create a client chat session with

```
Chat chatSession = new Chat(bot);
```

# Chat with the bot #

Use the method multisentenceResponse to get the bot's replies to multiple-sentence (one or more sentence) inputs:

```
String request = "Hello.  Are you alive?  What is your name?"
String response = chatSession.multisentenceRespond(request);
System.out.println(response);
```