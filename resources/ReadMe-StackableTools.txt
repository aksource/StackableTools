mod_StackableTools　スタックツールmod


説明
	ツール類をスタック可能にします。
	スタック数は設定ファイルから変更できます。
	ダメージ値やエンチャントの異なるツールはスタックできません。
	一部のツールは機能が変更されています。

対象アイテム
	斧、つるはし、ショベル、剣、弓、防具
	クワ、ハサミ、釣竿、火打石

機能変更点
	斧、つるはし、ショベル、剣
		素手で一撃で倒せるMOBを攻撃した際、耐久が減らない
	剣
		くもの巣の破壊速度を、素材によって変更
		くもの巣を壊した際の耐久減少量を１に（設定ファイルで変更可能）

不具合という名の仕様（修正不可）
	・耐久が同じアイテム同士をスタックした後ツールが壊れると新品になる
	・耐久が減ったままスタックを分けると、両方とも耐久が減っている


導入方法
	MinecraftForgeが必要です。
	modsフォルダにzipファイルのまま突っ込んでください。


履歴
-4	空き防具スロットのテクスチャがおかしくなる不具合修正
-3	設定がバニラと同じ1の時は置き換えしないように修正
-2	エメラルドを掘れないバグ修正
-1	公開
