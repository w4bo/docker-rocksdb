const publishCmd = `
chmod +x *.sh; ./publish.sh \${nextRelease.version} w4bo rocksdb
`;
const config = require('semantic-release-preconfigured-conventional-commits');
config.plugins.push(
    ["@semantic-release/exec", { "publishCmd": publishCmd, }],
    ["@semantic-release/github", [{"path": "image/java-libs/*.jar"}, {"path": "image/java-libs/*.so"}]],
    "@semantic-release/git"
)
module.exports = config
