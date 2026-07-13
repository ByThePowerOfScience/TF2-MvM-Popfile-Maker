
grammar VDF;

root : lines+=line (NL lines+=line)*;

line : keyvalue? COMMENT?;

keyvalue : keyvalue_strings
   | keyvalue_table
   ;

keyable : LITERAL | STRING;
keyvalue_strings : key=keyable value=keyable;
keyvalue_table :
                key=keyable ((keyEOLComment+=COMMENT)? NL)+
                 value=table
                ;

table : OPENBRACE tableLBracketComment=COMMENT?
        (NL lines+=line)+
        CLOSEBRACE;



COMMENT : COMMENT_START ~('\r' | '\n')* ;

WS: [\p{Zs}\t]+ -> skip;

STRING: QUOTE (STRING_ELEMENT)* QUOTE ;
LITERAL: ~["{}\p{Zs}\t\n\r]+ ;

QUOTE : '"';

COMMENT_START : '//';

fragment STRING_ELEMENT : '\\"' | ~'"';

NL: '\r'? '\n';

//fragment WORDCHAR: [\p{L}\p{N}\-_.#];

OPENBRACE : '{' ;
CLOSEBRACE : '}' ;

//PRAGMA : '#' WORDCHAR+ (WS | WORDCHAR | '.')+;
