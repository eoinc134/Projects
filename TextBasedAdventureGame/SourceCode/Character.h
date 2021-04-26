#ifndef CHARACTER_H
#define CHARACTER_H

#include <string>
#include "Item.h"
using namespace std;

class Character{
    protected:
        int health;
        string name;
        string greeting;

    public:    
        Character();
        Character(string name, int health);

        string getName();
        void setName(string name);

        int getHealth();
        void setHealth(int health);

        string getGreeting();

        virtual bool hasItem(string item) = 0;
        virtual Item getItem(string item) = 0;
        virtual void removeItem(string item) = 0;
};

#endif // CHARACTER_H
