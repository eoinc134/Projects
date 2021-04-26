#ifndef VALIDCOMMANDS_H
#define VALIDCOMMANDS_H

#include <string>
#include <iostream>
#include <vector>
using namespace std;

class ValidCommands{
    private:
        static vector<string> validCommands;

    public:
        ValidCommands();

        bool isCommand(string command);
        void showCommands();
};

#endif // VALIDCOMMANDS_H
