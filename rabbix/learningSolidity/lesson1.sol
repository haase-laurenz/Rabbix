//TOTO 1: Erstelle einen simplen Smart Contract, der einen Wert speichert und diesen Wert zurückgibt.

pragma solidity ^0.8.0;

contract SimpleStorage {
    // Der einzige gespeicherte Wert
    uint256 public data;

    // Funktion zum Setzen des Werts
    function set(uint256 _data) public {
        data = _data;
    }

    // Funktion zum Abrufen des Werts
    function get() public view returns (uint256) {
        return data;
    }
}
