const path = require('path');
// const webpack = require('webpack');
module.exports = {
  entry: './src/main.js',
  output: {
    //动态获取路径
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js',
    publicPath: 'dist/'
  },
  //css-loader只负责加载
  //style-loader负责将样式添加到dom
  //使用多个loader从右到左读
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      },
      {
        test: /\.less$/,
        use: [{
          loader: "style-loader" // creates style nodes from JS strings
        }, {
          loader: "css-loader" // translates CSS into CommonJS
        }, {
          loader: "less-loader" // compiles Less to CSS
        }]
      },
      // {
      //   test: /\.(png|jpg|gif)$/,
      //   use: [
      //     {
      //       loader: 'url-loader',
      //       options: {
      //         limit: 8192
      //       }
      //     }
      //   ]
      // },
      {
        test: /\.(png|jpg|gif)$/,
        use: [{
          loader: 'file-loader',
          options: {
            name: 'img/[name].[hash:8].[ext]'
          }
        }]
      },

      //npm install --save-dev babel-loader@7 babel-core babel-preset-es2015
      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            // presets: ['@babel/preset-env']
            presets: ['es2015']
          }
        }
      },
      {
        test:/\.vue$/,
        use:{
          loader:'vue-loader'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$':'vue/dist/vue.esm.js'
    }
  }
}