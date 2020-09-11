const path = require('path');

module.exports = {
    entry: './src/main.js',
    output: {
        //动态获取路径
        path:path.resolve(__dirname,'dist'),
        filename:'bundle.js'
    },
    // module:{
    //     rules:[
    //         {
    //             test: /\.css$/,
    //             //css-loader只负责加载
    //             //style-loader负责将样式添加到dom
    //             //使用多个loader从右到坐读
    //             use: ['style-loader','css-loader']
    //         }
    //     ]
    // }
    module: {
        rules: [
          {
            test: /\.css$/,
            use: [ 'style-loader', 'css-loader' ]
          }
        ]
      }
}