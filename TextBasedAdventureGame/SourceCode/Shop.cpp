#include "Shop.h"

vector<Item> Shop::stock;

Shop::Shop(){
    if(stock.empty())
    {
        stock.push_back(Item("bow", "A bow and arrows", 30, 30, true, false));
        stock.push_back(Item("chainmail", "A set of chainmail armour", 75, 75, false, false));
        stock.push_back(Item("longsword", "A large steel longsword", 75, 75, true, false));
    }
}

string Shop::showStock(){
    string s = "";
    for(int i = 0; i < (int) stock.size(); i++){
        cout << endl;
        s += stock[i].examineItem() + "\n";
    }
    return s;
}

bool Shop::hasItem(string item){
    for(int i = 0; i < (int) stock.size(); i++){
        if(stock[i].getItem().compare(item) == 0){
            return true;
        }
    }
    return false;
}

Item Shop::buyItem(string item){
    for(int i = 0; i < (int) stock.size(); i++){
        if(stock[i].getItem().compare(item) == 0){
            return stock[i];
        }
    }
    return Item("","",0,0,false,false);
}

void Shop::removeItem(string item){
    for(int i = 0; i < (int) stock.size(); i++){
        if(stock[i].getItem().compare(item) == 0){
            stock.erase(stock.begin() + i);
        }
    }
}
