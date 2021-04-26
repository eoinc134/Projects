#include "StringInputCLI.h"

StringInputCLI::StringInputCLI(){
    commands = ValidCommands();
}

Command StringInputCLI::getCommand(){
    string input;
    vector<string> words;
    string firstWord;
    string secondWord;

    cout << " > ";
    getline(cin, input, '\n');

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

void StringInputCLI::showCommands(){
    commands.showCommands();
}
