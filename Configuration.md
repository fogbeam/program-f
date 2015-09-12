# Configuration Files #



## Normalization ##

For a bot named botname, the normalization file is located in bots/botname/config/normal.txt.

The substitutions are written one per line, with double quotes surrounding the two terms.
The program is looking for inputs that match the regular expression
```
"\"(.*?)\",\"(.*?)\"" 
```
like
```
" haven't "," have not "
" realy "," really "
".uk "," dot uk " 
```
Many of the substitutions begin and end with a space.  This is to ensure whole-word substitution.  The preprocessor appends a space to the beginning and end of each sentence, applies all the substitutions, and then trims off the leading and ending spaces.

A peculiar case is
```
"""," " 
```

The double quote doesn’t have to be escaped to match the regular expression.

## Predicate Defaults ##

The file config/predicates.txt contains any predicate default values.
The format is

```
predicate:value
```

For example:

```
age:how many
baby:who
bestfriend:who
birthday:when
birthplace:where
boyfriend:who
brother:who
cat:what
city:which
country:which
county:which
customname:unknown
daughter:who
dialnumber:unknown
dog:who
```

## Bot Properties ##

The file config/properties.txt contains the bot properties.  The format is identical to the format for predicate defaults.  For example:

```
url:http://www.alicebot.org
name:SUPER
email:callmom-info@pandorabots.com
gender:male
botmaster:Dr. Richard S. Wallace
organization:ALICE AI Foundation
version:0.0.4
```

## Substitutions ##

These files store the substitutions for certain AIML tags.  The format is identical to the format for normalizing substitutions.  Here is a sample from person.txt:

```
" with you "," with me2 " 
" with me "," with you2 "
" to you "," to me2 " 
" to me "," to you2 "
" of you "," of me2 " 
" of me "," of you2 "
```

The substitutions are applied in order from top to bottom.

The following table summarizes the organization of substitution files:

| **File** | **AIML Tag** |
|:---------|:-------------|
| normal.txt | `<normalize>` |
| person.txt | `<person>`   |
| person2.txt | `<person2>`  |
| gender.txt | `<gender>`   |


## Copyright ##

Copyright statement

The directory config/ contains a file called copyright.txt.   The conversion program will read this file and place a copyright statement in an XML comment at the top of each AIML file.   The copyright.txt file may contain some macro commands that the conversion program will expand according the following table.  These macros help you write a custom copyright statement applicable to your bot.

| Macro | 	Expansion |
|:------|:-----------|
| `[url]`  |	the URL specified by the bot property url in the file properties.txt |
| `[date]`  |	the current date |
| `[YYYY]`  |	the current calendar year |
| `[version]`  |	the bot property version from properties.txt |
| `[botname]` |	the botname property from properties.txt |
| `[botmaster]`	 | the botmaster property from properties.txt |
| `[organization]` |	the organization property from properties.txt |

## API Keys ##

If you are planning to use [Pannous web service](https://demo.pannous.com/) with `<sraix>`, please refer to [Jeannie API](https://www.mashape.com/pannous/jeannie#pricing) and obtain a login and apikey.  Program AB looks for these values in the files:

config/pannous-login.txt
config/pannous-apikey.txt

If these files are absent, the program assigns the default values

```
pannous_api_key = "guest"
pannous_login = "test-user"
```