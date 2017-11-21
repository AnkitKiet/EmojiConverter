# EmojiConverter
This is an Android library used to convert text to Emojis in edittext. This is the most stable version of this library till date. This is under more modifications. Use It For Free.
## Preview

![Sample](/ezgif-4-63891ff6bd.gif?raw=true "Preview")

## Installation
### Gradle
Add below code in build.gradle
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
		}
	}
```
Add a dependency
```
dependencies {
	compile 'com.github.AnkitKiet:EmojiConverter:1.14'
	}
```

### Maven
Add below code for Maven installation
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Add a dependency
```
<dependency>
	    <groupId>com.github.User</groupId>
	    <artifactId>Repo</artifactId>
	    <version>Tag</version>
	</dependency>
```

## How To Use

paste below code in java file

```
        EmojiConverter edt = (EmojiConverter) findViewById (R.id.edtRawText); //Try not adding Textwatcher on this
        final EmojiConverter emojiConverter=new EmojiConverter(MainActivity.this);
  	editText.setText(emojiConverter.convertEmoji()); //use this on an event, like a button click

```
paste below code in layout xml file.
```
 <edu.texttoemoji.EmojiConverter
        android:id="@+id/edtRawText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="type something"/>
	
```


## License
```
Copyright 2017 Ankit Maurya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
