#include "StringInputGUI.h"

StringInputGUI::StringInputGUI(){
    commands = ValidCommands();
}

Command StringInputGUI::getCommand(){
    string input;
    vector<string> words;
    string firstWord;
    string secondWord;


    string delimiter = " ";
    size_t pos = 0;
    string token;
    while ((pos = input.find(delimiter)) != string::npos) {
        words.push_back(input.substr(0, pos));
        input.erase(0, pos + delimiter.length());
    }
    words.push_back(input);

    if(words.size() == 1){
        firstWord = words[0];
    } else if(words.size() == 2){
        firstWord = words[0];
        secondWord = words[1];
    }

    if(commands.isCommand(firstWord)){
        return Command(firstWord, secondWord);
    } else {
        return Command("", secondWord);
    }
}

Command StringInputGUI::getCommand(string word1, string word2){
    vector<string> words;
    string firstWord = word1;
    string secondWord = word2;

    if(words.size() == 1){
        firstWord = words[0];
    } else if(words.size() == 2){
        firstWord = words[0];
        secondWord = words[1];
    }

    if(commands.isCommand(firstWord)){
        return Command(firstWord, secondWord);
    } else {
        return Command("", secondWord);
    }
}



Command StringInputGUI::getCommand(string word1){
    vector<string> words;
    string firstWord = word1;
    string secondWord;

    if(words.size() == 1){
        firstWord = words[0];
    }

    return Command(word1, "");
}



void StringInputGUI::showCommands(){
    commands.showCommands();
}
