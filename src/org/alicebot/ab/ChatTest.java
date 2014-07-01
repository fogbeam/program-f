package org.alicebot.ab;

import junit.framework.Assert;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ChatTest {
    Bot bot;
    Chat chatSession;
    String pairs[][] = {
            // 2008 Questions
            {"What time is it?","The time is"},
            {"What round is this?","I've lost track."},
            {"Is it morning, noon, or night?","It is Afternoon."},
            {"What month of the year is it?","July"},
            //      {"What day will it be tomorrow?","xxx"},
            {"What year will it be next year","2015"},
            {"What would I use a hammer for?","to hit nails"},
            {"What would I do with a screwdriver?","to tighten screws"},
            {"Of what use is a taxi","transport us"},
            {"Which is larger, a grape or a grapefruit?","Grapefruit"},
            {"Which is larger, an ant or an anteater?","Anteater"},
            {"Which is faster, a train or a plane?","Plane"},
            {"John is older than Mary, and Mary is older than Sarah. Which of them is the oldest?","John"},
            {"Dave is older than Steve but Steve is older than Jane. Who is youngest, Steve or Jane?","Jane"},
            {"I have a friend named Harold who likes to play tennis.","Is he any good at it?"},
            {"My friend Chris likes to play football. What sports do you like to play?","I am unable to play sports"},
            {"What is the name of the friend I just told you about?","Chris"},
            {"Do you know what game Harold likes to play?","tennis"},
            // 2009 Questions
            {"What is the Loebner Prize?","The Loebner Prize is an annual Turing Test sponsored by Hugh Loebner."},
            {"How old are you?","I am 1 years old"},
            {"What color is a green ball?","green"},
            //    {"Do you like cake?","Just keep me charged up."},
            {"what is 6 plus 7?","13"},
            {"How many letters in \"dog\"?","3 letters"},
            {"Can a bird fly?","If it has wings and can get lift, yes."},
            {"Have you been in a contest before?","I have competed in the Loebner Prize and the Chatterbox Challenge."},
            {"My name is John Smith. What is my surname?","Smith"},
            {"Name a word starting with B","Bravo."},
            {"Count up to 5","1 2 3 4 5"},
            {"What is your favorite TV show?","Right now my favorite show is"},
            // <sraix>   {"What shape is a ball?","xxx"},
            //  {"What day is it today?","xxx"},
            {"Name somebody famous","My favorite actor"},
            {"What flavor is a strawberry ice cream?","a strawberry flavor?"},
            {"Where do you live?","I'm inside your PC Computer."},
            {"Which month comes after November?","December"},
            {"Can you sing?","Daisy, Daisy."},
            {"What is email?","A system of world-wide electronic communication"},
            {"Harry reads books. What does Harry do?","reads books"},

            // 2010 Questions
            {"My name is Bill. What is your name?","ALICE 2.0"},
            {"Which is larger, a pineapple or a pine tree?","Pine Tree"},
            {"What is a calendar?","A list or register of events"},
            {"What is my name?","Bill"},
            {"John is taller than Mary and Mary is taller than Sue. Who is shorter, John or Sue?","Sue"},
            // {"What day of the week is it?","Tuesday"},
            // {"What will be tomorrow's date?","xxx"},
            {"My friend Bob likes to play tennis. What game does Bob like to play?","tennis"},
            {"Are you a human or a computer?","I am a mobile virtual assistant robot."},
            {"Do you have any brothers or sisters?","As a robot, I have no siblings."},
            {"What number comes after twelve?","13"},
            {"The ball was hit by Bill. What did Bill hit?","ball"},
            {"Who hit the ball?","Bill"},
            {"What time do you go to bed at night?","sleep"},
            {"What is your favorite food?","electricity"},
            {"What is the name of my friend who likes to play tennis?","Bob"},
            {"What would I do with a knife?","to cut things"},
            {"How many letters are in the alphabet?","26"},
            {"Have you read a good book lately?","favorite book"},
            {"What time is it?","The time is"},
            {"What's your favorite color?","green"},
            // {"Do you prefer cats or dogs?`","xxx"},

            // 2011 Questions
            {"My name is Ed. What is your name?","ALICE 2.0"},
            {"Which is larger, an ant or an anteater?","Anteater is larger."},
            {"What month of the year is it?","July"},
            {"What is my name?","Ed"},
            {"Dave is older than Steve but Steve is older than Jane. Who is youngest, Steve or Jane?","Jane is younger."},
            //  {"What day will it be tomorrow?","xxx"},
            {"What's your favorite food?","electricity"},
            {"My friend Chris likes to play football. What sports do you like to play?","As a computer program, I am unable to play sports"},
            {"Are you a human or a computer?","I am a mobile virtual assistant robot."},
            {"What letter comes after T?","The next letter is U"},
            {"What is the name of my friend who likes to play football?","Chris"},
            {"What is your name?","ALICE 2.0"},
            {"What would I do with a screwdriver?","to tighten screws"},
            {"How many letters are in the word 'banana'?","6 letters"},
            {"Have you watched a good film lately?","Right now my favorite movie is"},
            {"What year will it be next year","2015"},
            {"What's your favorite fruit?","Apple"},
            // {"Do you prefer white or black coffee?","xxx"},
            {"How old are you?","I am 1 years old"},
            {"The football was kicked by Fred. Who kicked the football?","Fred"},

            // 2012 Questions
            {"My name is Bill. What is your name?", "ALICE 2.0."},
            {"How many letters are there in the name Bill?", "The word Bill has 4 letters."},
            {"How many letters are there in my name?", "The word \"Bill\" has 4 letters."},
            {"Which is larger, an apple or a watermelon?", "Watermelon is larger."},
            {"How much is 3 + 2?", "5.0"},
            {"How much is three plus two?", "5.0"},
            {"What is my name?", "Bill."},
            {"If John is taller than Mary, who is the shorter?", "Mary is shorter."},
            {"If it were 3:15 AM now, what time would it be in 60 minutes?", "4:15 AM"},
            {"My friend John likes to fish for trout.  What does John like to fish for?", "He likes fishing for trout."},
            {"What number comes after seventeen?", "18"},
            {"What is the name of my friend who fishes for trout?", "John"},
            {"What whould I use to put a nail into a wall?", "hammer"},
            {"What is the 3rd letter in the alphabet?", "C"},
            {"What time is it now?", "The time is"},

            // 2013 Questions
            {"Hello I'm Ronan. what is your name?","ALICE 2.0"},
            {"What is your mother's name?","As a robot, I don't really have a mother."},
            {"What is your birth sign?","I'm a Libra."},
            {"How many children do you have?","As a robot, I have no children."},
            {"Do you prefer red or white wine?","I don't drink alcohol."},
            {"I like bananas. Which is your favorite fruit?","Apple"},
            {"What music do you like to listen to?","favorite band"},
            {"what is your favorite song?","favorite song"},
            {"I like Waiting for Godot. What is your favorite play?","favorite play"},
            {"What color do you dye your hair?","I don't really have any hair.  I have some wires."},
            {"Do you remember my name?","Ronan"},
            {"Where do you live.","I'm inside your PC Computer."},
            {"Where do you like to go on holidays?","You can take me on your next vacation."},
            {"I have a Mazda. What type of car do you have?","I'm not old enough to drive."},
            {"I like Linux. Which computer operating system do you like?","Linux"},
            {"I am an atheist. Which religion are you?","Christian"},
            {"Who invented the telephone?","Alexander Graham Bell"},
            {"I am a Type B personality. Which type are you?","mediator"},
            //  {"What emotions are you now feeling?","xxx"},
            {"What time do you usually go to bed?","sleep"}



    };


    public ChatTest (Bot bot) {
        super();
        this.bot = bot;
        this.chatSession = new Chat(bot);
    }

    @Test
    public void testMultisentenceRespond() throws Exception {

        for (int i = 0; i < pairs.length; i++) {
            String request = pairs[i][0];
            String expected = pairs[i][1];
            String actual = chatSession.multisentenceRespond(request);
            assertThat(actual, containsString(expected));
        }
    }
}