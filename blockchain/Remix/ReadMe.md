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

cd remix-ide
```

5. install browserify
```
npm install -g browserify
```

6. install babelify
```
npm install --save-dev babelify
```

7. install module
```
npm install
```

8. npm run build
```
npm run build
```

9. start
```
npm start
```

we can load remix-ide page.
