import 'package:flutter/material.dart';
import 'main.dart';

class SecondPage extends StatefulWidget {

  static String tag = 'second-page';

  @override
  State<StatefulWidget> createState() => new _SecondPageState();

}

class _SecondPageState extends State<SecondPage> {
  @override
  Widget build(BuildContext context) {
    final logo = Hero(
      tag: 'hero',
      child: CircleAvatar(
        backgroundColor: Colors.transparent,
        radius: 48.0,
        child: Image.asset('assets/mosquito,jpeg'),
      ),
    );

    final email = TextFormField(
      keyboardType: TextInputType.emailAddress,
      autofocus: false,
      initialValue: 'test@domain.com',
      decoration: InputDecoration(
        hintText: 'Email',
        contentPadding: EdgeInsets.fromLTRB(8.0, 8.0, 8.0, 8.0),
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(32.0),
        )
      ),
    );

    final password = TextFormField(
      autofocus: false,
      initialValue: 'password',
      obscureText: true,
      decoration: InputDecoration(
          hintText: 'Password',
          contentPadding: EdgeInsets.fromLTRB(8.0, 8.0, 8.0, 8.0),
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(32.0),
          )
      ),
    );

    final nextButton = Padding(
      padding: EdgeInsets.symmetric(vertical: 16.0),
      child: Material(
        borderRadius: BorderRadius.circular(30.0),
        shadowColor: Colors.lightBlueAccent.shade100,
        elevation: 5.0,
        child: MaterialButton(
          minWidth: 200.0,
          height: 42.0,
          onPressed: (){
            Navigator.of(context).pushNamed(MyHomePage.tag);
          },
          color: Colors.lightBlueAccent,
          child: Text("Next", style: TextStyle(color: Colors.white)),
        ),
      ),
    );

    return Scaffold(
      backgroundColor: Colors.white,
      body: Center(
        child: ListView(
          shrinkWrap: true,
          padding: EdgeInsets.only(left: 16.0, right: 16.0),
          children: <Widget>[
            logo,
            SizedBox(height: 48.0),
            email,
            SizedBox(height: 8.0),
            password,
            SizedBox(height: 24.0),
            nextButton,
          ],
        ),
      ),
    );
  }
}