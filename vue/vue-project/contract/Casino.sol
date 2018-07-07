pragma solidity ^0.4.24;

contract Ownable {
  address owner;
  function Ownable() public {
    owner = msg.sender;
  }

  modifier Owned {
    require(msg.sender == owner);
    _;
  }
}

contract Mortal is Ownable {
  function kill() public Owned {
    selfdestruct(owner);
  }
}

contract Casino is Mortal{
  uint minBet;
  uint houseEdge; //in %

  event Won(bool _status, uint _amount);

  function Casino(uint _minBet, uint _houseEdge) payable public {
    require(_minBet > 0);
    require(_houseEdge <= 100);
    minBet = _minBet;
    houseEdge = _houseEdge;
  }

  function() public { //fallback
    revert();
  }

  function bet(uint _number) payable public {
    require(_number > 0 && _number <= 10);
    require(msg.value >= minBet);
    uint winningNumber = block.number % 10 + 1;
    if (_number == winningNumber) {
      uint amountWon = msg.value * (100 - houseEdge)/10;
      if(!msg.sender.send(amountWon)) revert();
      emit Won(true, amountWon);
    } else {
      emit Won(false, 0);
    }
  }

  function checkContractBalance() Owned public view returns(uint) {
      return address(this).balance;
  }

  /*
  ** Withdrawal function
  function withDraw(uint _amount) public Owned {
    require(address(this).balance > _amount);
    owner.transfer(_amount);
  }
  */
}