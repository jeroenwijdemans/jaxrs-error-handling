#!/usr/bin/env bash
echo 'deploy ... '
if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_3fc0e7b86c25_key -iv $encrypted_3fc0e7b86c25_iv -in ./cd/codesigning.asc.enc -out ./cd/codesigning.asc -d
    gpg --fast-import ./cd/codesigning.asc
    ./gradlew uploadArchives -s
    echo "Finished uploading archives"
else
    echo "Nothing to deploy on branch ${TRAVIS_BRANCH}.."
fi
