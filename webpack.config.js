const webpack = require("webpack");
const path = require("path");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require("extract-text-webpack-plugin");

const extractSass = new ExtractTextPlugin({
    filename: "[name].[contenthash].css",
    disable: process.env.NODE_ENV === "development"
});

module.exports = {
    entry: {
        main: "scripts/main.ts",
        vendor: "scripts/vendor.ts",
        polyfill: "scripts/polyfill.ts"
    },
    resolve: {
        modules: [
            path.resolve('./src/main/ui/app'),
            "node_modules"
        ],
        extensions: ['.ts', '.js', '.scss' ]
    },
    output: {
        path: path.resolve('./src/main/resources/public'),
        filename: "[name].[hash].js"
    },
    module: {
        loaders: [
            {
                test: /\.ts$/,
                loader: 'ts-loader'
            },
            {
                test: /\.scss$/,
                use: extractSass.extract({
                    use: [{
                        loader: "css-loader"
                    }, {
                        loader: "sass-loader"
                    }],
                    fallback: "style-loader"    // use style-loader in development
                })
            }, {
                test: /\.(png|jpg|jpeg|gif|svg|woff|woff2)$/,
                loader: 'url-loader?limit=10000'
            }, {
                test: /\.(eot|ttf|wav|mp3)$/,
                loader: 'file-loader'
            }
        ]
    },
    plugins: [
        new CleanWebpackPlugin(
            ['./src/main/resources/public']
        ),
        new webpack.ContextReplacementPlugin(   //https://github.com/angular/angular/issues/11580
            /angular(\\|\/)core(\\|\/)@angular/,
            path.resolve(__dirname, '../src')
        ),
        new CopyWebpackPlugin([
            {from: 'template/**/*.html', context: './src/main/ui/app/'},
            {from: '**/*.html', context: './src/main/ui/app/scripts/'},
            {from: 'views/**/*.html', context: './src/main/ui/app/'},
            {from: 'images/**', context: './src/main/ui/app/'}
        ]),
        extractSass,
        new webpack.optimize.CommonsChunkPlugin({
            name: ['main', 'vendor', 'polyfill']
        }),
        new HtmlWebpackPlugin({
            template: './src/main/ui/app/index.html'
        })
    ],
    devServer: {
        contentBase: path.resolve('./src/main/resources/public'),
        port: 9000,
        watchContentBase: true,
        proxy: {
            "/api": "http://localhost:8080"
        }
    }
};