const path = require("path");
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
    entry: "scripts/app.ts",
    resolve: {
        modules: [
            path.resolve('./src/main/ui/app'),
            "node_modules"
        ],
        extensions: ['.ts', '.js']
    },
    output: {
        path: path.resolve('./src/main/resources/public'),
        filename: "bundle.js"
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
            {from: '**/*.html', context: './src/main/ui/app/'},
            {from: '**/*.css', context: './src/main/ui/app/'},
            {from: 'images/**', context: './src/main/ui/app/'},
            {from: 'css/bootstrap.min.css', context: './node_modules/bootstrap/dist/', to: './styles/vendors/'},
            {from: 'fonts/**', context: './node_modules/bootstrap/dist/', to: './styles/'}
        ])
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