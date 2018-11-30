const path = require('path')
const CleanWebpackPlugin = require('clean-webpack-plugin')
const TsconfigPathPlugin = require('tsconfig-paths-webpack-plugin')
const HtmlWebpackPlugin = require('html-webpack-plugin')

// exclude : 로더를 통해 컴파일 하지 않을 것을 지정, 로더로 컴파일 하지 않지만 웹팩으로는 컴파일 함
// include : 꼭 이 로더를 이용해 컴파일

const HTML_OPTIONS = {
    template: "./index.html",
    minify: {
        collapseWhitespace: true,
        removeAttributeQuotes: true
    }
}

module.exports = {
    entry: "./src/index.tsx",
    devtool: "source-map",
    output: {
        path: path.resolve(__dirname, 'build'),
        filename: 'bundle.js'
    },
    mode: 'development',
    module: {
        rules: [
            {
                test: /\.(css|scss)$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.tsx?$/,
                use: [
                    {
                        loader: 'ts-loader'
                    }
                ],
                exclude: [/node_modules/]
            },
            {
                test: /\.(ico|png|jpg|jpeg|gif|svg|woff|woff2|ttf|eot)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            name: '[name].[ext]?[hash]'
                        }
                    }
                ]
            }
        ]
    },
    plugins: [
        // new CleanWebpackPlugin(["build"]),
        new HtmlWebpackPlugin(HTML_OPTIONS)
    ],
    resolve: {
        extensions: [".ts", ".tsx", ".js", ".jsx"],
        plugins: [new TsconfigPathPlugin({configFile: "./tsconfig.json"})]
    },
    devServer: {
        port: 3000,
        contentBase: "./",
        historyApiFallback: true
    }
}