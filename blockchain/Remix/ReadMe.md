## Remix (basic)

1. install
> needs node, npm

```
npm install remix-ide -g
```

2. cd root npm directory
```
cd /Users/{user}/.npm-packages/lib/node_modules/remix-ide/bin
```

3. run ide
```
./remix-ide
```



## Remix (Docker Ubuntu)

1. docker install

2. create docker ubuntu image
```
docker pull ubuntu
```

3. docker run
```
docker run -i -t --name ubuntu ubuntu /bin/bash
```

4. install remix
```
apt-get update
apt-get install wget
apt-get install node
apt-get install npm

git clone "git clone https://github.com/ethereum/remix-ide.git"

then ... error

```

5. change package.json
```
"setupremix": "npm run pullremix && npm run linkremixcore && npm run linkremixlib && npm run linkremixsolidity;"
--> // current remix repository has not remix-core
"setupremix": "npm run pullremix && npm run linkremixlib && npm run linkremixsolidity;"
```

6. insert soljson.js
```
cd node_modules/solc

wget https://ethereum.github.io/solc-bin/soljson.js
```

7. change directory remix-ide home
```
cd ../..
npm run build // but.. error
```

8. start
```
npm start
```

we can load remix-ide page.

but, has some error.
