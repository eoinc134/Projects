#include "ValidCommands.h"

vector<string> ValidCommands::validCommands;

ValidCommands::ValidCommands(){
    if(validCommands.empty())
    {      
        validCommands.push_back("map");
        validCommands.push_back("search");
        validCommands.push_back("examine");
        validCommands.push_back("go");
        validCommands.push_back("take");
        validCommands.push_back("drop");
        validCommands.push_back("use");
        validCommands.push_back("buy");
        validCommands.push_back("help");
        validCommands.push_back("quit");
    }
}


bool ValidCommands::isCommand(string command){
    for(int i = 0; i < (int) validCommands.size(); i++){
        if(validCommands[i].compare(command) == 0)
            return true;
    }

    return false;
}
void ValidCommands::showCommands(){
    for(int i = 0; i < (int) validCommands.size(); i++){
        cout << " " << validCommands[i] << "\n";
    }
}
