#ifndef PLAYER_H
#define PLAYER_H

#include "Character.h"
#include "Room.h"
#include <string>
#include <vector>
using namespace std;

class Player:  public Character{
    private:
        int numberOfItems;
        int inventorySize;
        vector<Item> inventory;
        string greeting = " Thank you for playing";

    public:
        Player();
        Player(string name, int health);

        void setHealth(int health);

        void takeItem(Item item);
        bool isFull(int weight);

        bool hasItem(string itemName);        
        Item getItem(string itemName);
        void removeItem(string itemName);

        void addCoins(Item item);
        int getCoins();
        void removeCoins(Item item);

        string items();
};

#endif // PLAYER_H
