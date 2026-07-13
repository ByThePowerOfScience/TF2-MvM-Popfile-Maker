
grammar VDF;

root : (bases+=header_allowed_lines)* firstLine=line (NL rest+=line)*;

header_allowed_lines : PRAGMA? COMMENT? NL;

line : keyvalue | keyvalue COMMENT | COMMENT?;

keyvalue : keyvalue_strings
   | keyvalue_table
   ;

keyable : NUMBER | LITERAL | STRING;
keyvalue_strings : key=keyable value=keyable;
keyvalue_table :
                key=keyable ((keyEOLComment+=COMMENT)? NL)+
                 value=table
                ;






table : OPENBRACE tableLBracketComment=COMMENT?
        (NL lines+=line)+
        CLOSEBRACE;



COMMENT : COMMENT_START ~('\r' | '\n')* ;

WS: [\t ]+ -> skip;

STRING: '"' (STRING_ELEMENT)* '"' ;
NUMBER: '-'? (([0-9]+ ('.' [0-9]+)?) | ('.' [0-9]+)) ;
LITERAL: [\p{L}] WORDCHAR+ ;

COMMENT_START : '//';

fragment STRING_ELEMENT : '\\"' | ~'"';

NL: '\r'? '\n';

fragment WORDCHAR: [\p{L}\p{N}\-_];

OPENBRACE : '{' ;
CLOSEBRACE : '}' ;

PRAGMA : '#' WORDCHAR+ (WS | WORDCHAR | '.')+;
