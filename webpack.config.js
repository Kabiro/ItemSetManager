const webpack = require("webpack");
const path = require("path");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    entry: {
        app: "scripts/app.ts",
        vendor: "scripts/vendor.ts"
    },
    resolve: {
        modules: [
            path.resolve('./src/main/ui/app'),
            "node_modules"
        ],
        extensions: ['.ts', '.js']
    },
    output: {
        path: path.resolve('./src/main/resources/public'),
        filename: "[name].[hash].js"
    },
    module: {
        loaders: [
            {test: /\.ts$/, loader: 'ts-loader'}
        ]
    },
    plugins: [
        new CleanWebpackPlugin(
            ['./src/main/resources/public']
        ),
        new CopyWebpackPlugin([
            {from: 'template/**/*.html', context: './src/main/ui/app/'},
            {from: 'views/**/*.html', context: './src/main/ui/app/'},
            {from: '**/*.css', context: './src/main/ui/app/'},
            {from: 'images/**', context: './src/main/ui/app/'},
            {from: 'css/bootstrap.min.css', context: './node_modules/bootstrap/dist/', to: './styles/vendors/'},
            {from: 'fonts/**', context: './node_modules/bootstrap/dist/', to: './styles/'}
        ]),
        new webpack.optimize.CommonsChunkPlugin({
            name: ['app', 'vendor']
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