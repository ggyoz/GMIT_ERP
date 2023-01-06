const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app){
    app.use(['/api','/api/auth'],
        createProxyMiddleware(
        {
            target : 'http://localhost:8080',
            changeOrigin: true,
            pathRewrite: {'^/api':''}
        })
    );
};

