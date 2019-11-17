group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    `bintray-release`
}

dependencies {
    api(project(":$RELEASE_ARTIFACT-features:jfoenix-commons"))
    api(project(":$RELEASE_ARTIFACT-features:jfoenix-coroutines"))
    api(project(":$RELEASE_ARTIFACT-features:jfoenix-layouts"))
    api(project(":$RELEASE_ARTIFACT-features:jfoenix-listeners"))
}

publishKotlinFix()
publish {
    bintrayUser = BINTRAY_USER
    bintrayKey = BINTRAY_KEY
    dryRun = false
    repoName = RELEASE_ARTIFACT

    userOrg = RELEASE_USER
    groupId = RELEASE_GROUP
    artifactId = "$RELEASE_ARTIFACT-jfoenix"
    publishVersion = RELEASE_VERSION
    desc = RELEASE_DESC
    website = RELEASE_WEB
}