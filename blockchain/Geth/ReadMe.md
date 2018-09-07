## Geth Install and Run

### 0. Environment

```
OS : Docker Ubuntu 18.04 LTS
Needs : 1.7 version Go

sudo docker run -i -t -p 8545:8545 --name geth ubuntu /bin/bash
```
### 1. apt package update

```
apt-get update
apt-get install -y git
apt-get install curl
```


### 2. install Go

```
// Download the latest distribution
curl -O https://storage.googleapis.com/golang/go1.7.3.linux-amd64.tar.gz

// Unpack it to the /usr/local
tar -C /usr/local -xzf go1.7.3.linux-amd64.tar.gz

// Set GOPATH and PATH
mkdir -p ~/go; echo "export GOPATH=$HOME/go" >> ~/.bashrc

// Update your Path
echo "export PATH=$PATH:$HOME/go/bin:/usr/local/go/bin" >> ~/.bashrc

source ~/.bashrc
```

### 3. install go-ethereum

```
git clone https://github.com/ethereum/go-ethereum

sudo apt-get install -y build-essential golang
```

### 4. run geth

```
/// build geth
cd go-ethereum
make geth

// run geth
build/bin/geth
```