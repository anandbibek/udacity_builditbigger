package com.java.joke;

import java.util.Random;

public class JokeClass {

    private static final String JOKES = "There are only 10 types of people in the world- those that understand binary and those that don't.\n" +
            "Computers make very fast, very accurate mistakes.\n" +
            "Be nice to the nerds, for all you know they might be the next Bill Gates!\n" +
            "Artificial intelligence usually beats real stupidity.\n" +
            "To err is human - and to blame it on a computer is even more so.\n" +
            "CAPS LOCK : Preventing Login Since 1980.\n" +
            "The truth is out there. Anybody got the URL?\n" +
            "The Internet: where men are men, women are men, and children are FBI agents.\n" +
            "Some things Man was never meant to know. For everything else, there's Google.\n" +
            "Operating Systems\n" +
            "The box said 'Requires Windows Vista or better'. So I installed LINUX.\n" +
            "UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity.\n" +
            "In a world without fences and walls, who needs Gates and Windows?\n" +
            "Bugs come in through open Windows.\n" +
            "Penguins love cold, they wont survive the sun.\n" +
            "Unix is user friendly. It's just selective about who its friends are.\n" +
            "Failure is not an option. It comes bundled with your Microsoft product.\n" +
            "NT is the only OS that has caused me to beat a piece of hardware to death with my bare hands.\n" +
            "Microsoft: \"You've got questions. We've got dancing paperclips.\"\n" +
            "Erik Naggum: \"Microsoft is not the answer. Microsoft is the question. NO is the answer.\"\n" +
            "Windows isn't a virus, viruses do something.\n" +
            "Computers are like air conditioners: they stop working when you open Windows.\n" +
            "Mac users swear by their Mac, PC users swear at their PC.\n" +
            "one line jokes\n" +
            "If at first you don't succeed; call it version 1.0.\n" +
            "My software never has bugs. It just develops random features.\n" +
            "I would love to change the world, but they won't give me the source code.\n" +
            "The code that is the hardest to debug is the code that you know cannot possibly be wrong.\n" +
            "Beware of programmers that carry screwdrivers.\n" +
            "Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.\n" +
            "The beginning of the programmer's wisdom is understanding the difference between getting program to run and having a runnable program.\n" +
            "I'm not anti-social; I'm just not user friendly.\n" +
            "Hey! It compiles! Ship it!\n" +
            "If Ruby is not and Perl is the answer, you don't understand the question.\n" +
            "The more I C, the less I see.\n" +
            "COBOL programmers understand why women hate periods.\n" +
            "Michael Sinz: \"Programming is like sex, one mistake and you have to support it for the rest of your life.\"\n" +
            "If you give someone a program, you will frustrate them for a day; if you teach them how to program, you will frustrate them for a lifetime.\n" +
            "Programmers are tools for converting caffeine into code.\n" +
            "My attitude isn't bad. It's in beta.\n" +
            "Enter any 11-digit prime number to continue.\n" +
            "E-mail returned to sender, insufficient voltage.\n" +
            "All wiyht. Rho sritched mg kegtops awound?\n" +
            "Black holes are where God divided by zero.\n" +
            "If I wanted a warm fuzzy feeling, I'd antialias my graphics!\n" +
            "If brute force doesn't solve your problems, then you aren't using enough.\n" +
            "SUPERCOMPUTER: what it sounded like before you bought it.\n" +
            "Evolution is God's way of issuing upgrades.\n" +
            "Linus Torvalds: \"Real men don't use backups, they post their stuff on a public ftp server and let the rest of the world make copies.\"\n" +
            "Hacking is like sex. You get in, you get out, and hope that you didn't leave something that can be traced back to you.\n" +
            "Calculations\n" +
            "There are three kinds of people: those who can count and those who can't.\n" +
            "Latest survey shows that 3 out of 4 people make up 75% of the world's population.\n" +
            "Hand over the calculator, friends don't let friends derive drunk.\n" +
            "An infinite crowd of mathematicians enters a bar. The first one orders a pint, the second one a half pint, the third one a quarter pint... \"I understand\", says the bartender - and pours two pints.\n"
            ;

    public static String getJoke(){
        String[] jokes = JOKES.split("\n");
        return jokes[new Random().nextInt(jokes.length)];
    }
}
