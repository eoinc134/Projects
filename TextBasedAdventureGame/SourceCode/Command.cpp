#include "Command.h"

Command::Command(string firstWord, string secondWord){
    this->firstWord = firstWord;
    this->secondWord = secondWord;
}

string Command::getFirstWord(){
    return this->firstWord;
}

string Command::getSecondWord(){
    return this->secondWord;
}
