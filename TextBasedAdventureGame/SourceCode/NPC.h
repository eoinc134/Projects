#ifndef NPC_H
#define NPC_H

#include "Character.h"
#include "Shop.h"
#include <string>
using namespace std;

class NPC: public Character{
    private:       
        bool hostile;
        int damage;
        string greeting;
        Shop s;

    public:
        NPC(string name, int health, bool isHostile, int damage, string greeting);

        bool isHostile();
        void setHostility(bool hostile);
        int getDamage();
        string getGreeting();

        string getStock();
        bool hasItem(string item);
        Item getItem(string item);
        void removeItem(string item);
};
#endif // NPC_H
