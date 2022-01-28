import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import axios from 'axios';
import chiseiIcon from '../../assets/ChiseiIcon.png';
import kenIcon from '../../assets/KenIcon.png';
import seishinIcon from '../../assets/SeishinIcon.png';
import surpriseIcon from '../../assets/SurpriseIcon.png';
import hPIcon from '../../assets/HPIcon.png';
import pWIcon from '../../assets/PWIcon.png';
import attackIcon from '../../assets/AttackIcon.png';
import defenseIcon from '../../assets/DefenseIcon.png';
import defaultArms from '../../assets/A-20-00-00-00-10-001.png';
import defaultHead from '../../assets/H-30-00-00-00-10-001.png';
import defaultLegs from '../../assets/L-40-00-00-00-10-001.png';
import defaultTorso from '../../assets/T-50-00-00-00-10-001.png';
import defaultWaist from '../../assets/W-60-00-00-00-10-001.png';
import mArtistArms from '../../assets/A-20-20-20-10-10-001.png';
import mArtistHead from '../../assets/H-30-20-20-20-80-001.png';
import mArtistBackHead from '../../assets/H-33-20-20-20-80-001.png';
import mArtistLegs from '../../assets/L-40-20-20-00-10-001.png';
import mArtistTorso from '../../assets/T-50-20-20-00-20-001.png';
import mArtistWaist from '../../assets/W-60-20-20-20-00-001.png';
import fMonsterArms from '../../assets/A-20-40-50-70-00-001.png';
import fMonsterHead from '../../assets/H-30-40-50-70-40-001.png';
import fMonsterLegs from '../../assets/L-40-40-50-70-10-001.png';
import fMonsterTorso from '../../assets/T-50-40-50-70-00-001.png';
import fMonsterBackTorso from '../../assets/T-55-40-50-70-20-001.png';
import fMonsterWaist from '../../assets/W-60-40-50-10-00-001.png';

function Arena() {
    let loggedInUser = localStorage.getItem("loggedInUser");
    loggedInUser = Number.parseInt(loggedInUser, 10);
    let arenaOpponent = localStorage.getItem("arenaOpponent");
    arenaOpponent = Number.parseInt(arenaOpponent, 10);
    let movePass = '';
    let params ={};
    console.log("Player:",loggedInUser);
    console.log("Opponent:",arenaOpponent);
    const baseURL = "http://localhost:8080/findUserById?userId="+loggedInUser;
    const oppURL = "http://localhost:8080/findUserById?userId="+arenaOpponent;
    const [attacker, setAttacker] = useState({
        userId: 0,
            userName: '',
        statId: 0,
            chisei: 0,ken: 0,seishin: 0,attack: 0,defense: 0,pwr: 0,totalHit: 0,
        avatarId: 0,
            armsId: 0,
                arms: '',armsName: '',armsDesc: '',armsImage: '',
            headId: 0,
                head: '',headName: '',headDesc: '',headImage: '',
            legsId: 0,
                legs: '',legsName: '',legsDesc: '',legsImage: '',
            torsoId: 0,
                torso: '',torsoName: '',torsoDesc: '',torsoImage: '',
            waistId: 0,
                waist: '',waistName: '',waistDesc: '',waistImage: '',
        movesetId: 0,
            cMoveId: 0,
                cMove: '',cMoveName: '',cMoveDesc: '',cMoveStat: 0,cMoveBuff: 0,cMoveKey: null,
            kMoveId: 0,
                kMove: '',kMoveName: '',kMoveDesc: '',kMoveStat: 0,kMoveBuff: 0,kMoveKey: null,
            sMoveId: 0,
                sMove: '',sMoveName: '',sMoveDesc: '',sMoveStat: 0,sMoveBuff: 0,sMoveKey: null,
            pMoveId: 0,
                pMove: '',pMoveName: '',pMoveDesc: '',pMoveStat: 0,pMoveBuff: 0,pMoveKey: null
    });
    const [defender, setDefender] = useState({
        userId: 0,
            userName: '',
        statId: 0,
            chisei: 0,ken: 0,seishin: 0,attack: 0,defense: 0,pwr: 0,totalHit: 0,
        avatarId: 0,
            armsId: 0,
                arms: '',armsName: '',armsDesc: '',armsImage: '',
            headId: 0,
                head: '',headName: '',headDesc: '',headImage: '',
            legsId: 0,
                legs: '',legsName: '',legsDesc: '',legsImage: '',
            torsoId: 0,
                torso: '',torsoName: '',torsoDesc: '',torsoImage: '',
            waistId: 0,
                waist: '',waistName: '',waistDesc: '',waistImage: '',
        movesetId: 0,
            cMoveId: 0,
                cMove: '',cMoveName: '',cMoveDesc: '',cMoveStat: 0,cMoveBuff: 0,cMoveKey: null,
            kMoveId: 0,
                kMove: '',kMoveName: '',kMoveDesc: '',kMoveStat: 0,kMoveBuff: 0,kMoveKey: null,
            sMoveId: 0,
                sMove: '',sMoveName: '',sMoveDesc: '',sMoveStat: 0,sMoveBuff: 0,sMoveKey: null,
            pMoveId: 0,
                pMove: '',pMoveName: '',pMoveDesc: '',pMoveStat: 0,pMoveBuff: 0,pMoveKey: null
    });
    console.log(JSON.stringify(attacker));
    let [nowBattle, setNowBattle] = useState({
        battleId: 0,
            attacker: 999,
            attackerHP: 10,
            attackerSurpriseCount: 0,
            defender: 900,
            defenderHP: 10,
            defenderSurpriseCount: 0,
        resultId: 0,
            winner: 'n/a',
            roundCount: 0,
            roundList: null,
            formula: ''
    });
    console.log(nowBattle);

    useEffect(() => {
        console.log("Retrieving user data...");
        axios.get(baseURL).then((response) => {
            console.log(JSON.stringify(response.data));
            setAttacker({
                userId: Number.parseInt(response.data.userId, 10),
                    userName: response.data.userName,
                statId: Number.parseInt(response.data.userStats.statId, 10),
                    chisei: Number.parseInt(response.data.userStats.chisei, 10),
                    ken: Number.parseInt(response.data.userStats.ken, 10),
                    seishin: Number.parseInt(response.data.userStats.seishin, 10),
                    attack: Number.parseFloat(response.data.userStats.attack, 10),
                    defense: Number.parseFloat(response.data.userStats.defense, 10),
                    pwr: Number.parseFloat(response.data.userStats.pwr, 10),
                    totalHit: Number.parseFloat(response.data.userStats.hit),
                avatarId: Number.parseInt(response.data.avatar.avatarId, 10),
                    armsId: Number.parseInt(response.data.avatar.armsPart.armsId,10),
                        arms: response.data.avatar.armsPart.arms,
                        armsName: response.data.avatar.armsPart.armsName,
                        armsDesc: response.data.avatar.armsPart.armsDesc,
                        armsImage: response.data.avatar.armsPart.armsImageFile,
                    headId: Number.parseInt(response.data.avatar.headPart.headId,10),
                        head: response.data.avatar.headPart.head,
                        headName: response.data.avatar.headPart.headName,
                        headDesc: response.data.avatar.headPart.headDesc,
                        headImage: response.data.avatar.headPart.headImageFile,
                    legsId: Number.parseInt(response.data.avatar.legsPart.legsId,10),
                        legs: response.data.avatar.legsPart.legs,
                        legsName: response.data.avatar.legsPart.legsName,
                        legsDesc: response.data.avatar.legsPart.legsDesc,
                        legsImage: response.data.avatar.legsPart.legsImageFile,
                    torsoId: Number.parseInt(response.data.avatar.torsoPart.torsoId,10),
                        torso: response.data.avatar.torsoPart.torso,
                        torsoName: response.data.avatar.torsoPart.torsoName,
                        torsoDesc: response.data.avatar.torsoPart.torsoDesc,
                        torsoImage: response.data.avatar.torsoPart.torsoImageFile,
                    waistId: Number.parseInt(response.data.avatar.waistPart.waistId,10),
                        waist: response.data.avatar.waistPart.waist,
                        waistName: response.data.avatar.waistPart.waistName,
                        waistDesc: response.data.avatar.waistPart.waistDesc,
                        waistImage: response.data.avatar.waistPart.waistImageFile,
                movesetId: Number.parseInt(response.data.moveset.movesetId, 10),
                    cMoveId: response.data.moveset.chiMove.cMoveId,
                        cMove: response.data.moveset.chiMove.cMove,
                        cMoveName: response.data.moveset.chiMove.moveName,
                        cMoveDesc: response.data.moveset.chiMove.moveDesc,
                        cMoveStat: Number.parseInt(response.data.moveset.chiMove.moveStat, 10),
                        cMoveBuff: Number.parseFloat(response.data.moveset.chiMove.moveBuff, 10),
                        cMoveKey: null,
                    kMoveId: response.data.moveset.kenMove.kMoveId,
                        kMove: response.data.moveset.kenMove.kMove,
                        kMoveName: response.data.moveset.kenMove.moveName,
                        kMoveDesc: response.data.moveset.kenMove.moveDesc,
                        kMoveStat: Number.parseInt(response.data.moveset.kenMove.moveStat, 10),
                        kMoveBuff: Number.parseFloat(response.data.moveset.kenMove.moveBuff, 10),
                        kMoveKey: null,
                    sMoveId: response.data.moveset.seiMove.sMoveId,
                        sMove: response.data.moveset.seiMove.sMove,
                        sMoveName: response.data.moveset.seiMove.moveName,
                        sMoveDesc: response.data.moveset.seiMove.moveDesc,
                        sMoveStat: Number.parseInt(response.data.moveset.seiMove.moveStat, 10),
                        sMoveBuff: Number.parseFloat(response.data.moveset.seiMove.moveBuff, 10),
                        sMoveKey: null,
                    pMoveId: response.data.moveset.surpriseMove.pMoveId,
                        pMove: response.data.moveset.surpriseMove.pMove,
                        pMoveName: response.data.moveset.surpriseMove.moveName,
                        pMoveDesc: response.data.moveset.surpriseMove.moveDesc,
                        pMoveStat: Number.parseInt(response.data.moveset.surpriseMove.moveStat, 10),
                        pMoveBuff: Number.parseFloat(response.data.moveset.surpriseMove.moveBuff, 10),
                        pMoveKey: null
            })
        })
        console.log("Retrieving opponent data...");
        axios.get(oppURL).then((response) => {
            setDefender({
                userId: Number.parseInt(response.data.userId, 10),
                    userName: response.data.userName,
                statId: Number.parseInt(response.data.userStats.statId, 10),
                    chisei: Number.parseInt(response.data.userStats.chisei, 10),
                    ken: Number.parseInt(response.data.userStats.ken, 10),
                    seishin: Number.parseInt(response.data.userStats.seishin, 10),
                    attack: Number.parseFloat(response.data.userStats.attack, 10),
                    defense: Number.parseFloat(response.data.userStats.defense, 10),
                    pwr: Number.parseFloat(response.data.userStats.pwr, 10),
                    totalHit: Number.parseFloat(response.data.userStats.hit),
                avatarId: Number.parseInt(response.data.avatar.avatarId, 10),
                    armsId: response.data.avatar.armsPart.armsId,
                        armsName: response.data.avatar.armsPart.armsName,
                        armsDesc: response.data.avatar.armsPart.armsDesc,
                        armsImage: response.data.avatar.armsPart.armsImageFile,
                    headId: response.data.avatar.headPart.headId,
                        headName: response.data.avatar.headPart.headName,
                        headDesc: response.data.avatar.headPart.headDesc,
                        headImage: response.data.avatar.headPart.headImageFile,
                    legsId: response.data.avatar.legsPart.legsId,
                        legsName: response.data.avatar.legsPart.legsName,
                        legsDesc: response.data.avatar.legsPart.legsDesc,
                        legsImage: response.data.avatar.legsPart.legsImageFile,
                    torsoId: response.data.avatar.torsoPart.torsoId,
                        torsoName: response.data.avatar.torsoPart.torsoName,
                        torsoDesc: response.data.avatar.torsoPart.torsoDesc,
                        torsoImage: response.data.avatar.torsoPart.torsoImageFile,
                    waistId: response.data.avatar.waistPart.waistId,
                        waistName: response.data.avatar.waistPart.waistName,
                        waistDesc: response.data.avatar.waistPart.waistDesc,
                        waistImage: response.data.avatar.waistPart.waistImageFile,
                movesetId: Number.parseInt(response.data.moveset.movesetId, 10),
                    cMoveId: response.data.moveset.chiMove.cMoveId,
                        cMove: response.data.moveset.chiMove.cMove,
                        cMoveName: response.data.moveset.chiMove.moveName,
                        cMoveDesc: response.data.moveset.chiMove.moveDesc,
                        cMoveStat: Number.parseInt(response.data.moveset.chiMove.moveStat, 10),
                        cMoveBuff: Number.parseFloat(response.data.moveset.chiMove.moveBuff, 10),
                        cMoveKey: null,
                    kMoveId: response.data.moveset.kenMove.kMoveId,
                        kMove: response.data.moveset.kenMove.kMove,
                        kMoveName: response.data.moveset.kenMove.moveName,
                        kMoveDesc: response.data.moveset.kenMove.moveDesc,
                        kMoveStat: Number.parseInt(response.data.moveset.kenMove.moveStat, 10),
                        kMoveBuff: Number.parseFloat(response.data.moveset.kenMove.moveBuff, 10),
                        kMoveKey: null,
                    sMoveId: response.data.moveset.seiMove.sMoveId,
                        sMove: response.data.moveset.seiMove.sMove,
                        sMoveName: response.data.moveset.seiMove.moveName,
                        sMoveDesc: response.data.moveset.seiMove.moveDesc,
                        sMoveStat: Number.parseInt(response.data.moveset.seiMove.moveStat, 10),
                        sMoveBuff: Number.parseFloat(response.data.moveset.seiMove.moveBuff, 10),
                        sMoveKey: null,
                    pMoveId: response.data.moveset.surpriseMove.pMoveId,
                        pMove: response.data.moveset.surpriseMove.pMove,
                        pMoveName: response.data.moveset.surpriseMove.moveName,
                        pMoveDesc: response.data.moveset.surpriseMove.moveDesc,
                        pMoveStat: Number.parseInt(response.data.moveset.surpriseMove.moveStat, 10),
                        pMoveBuff: Number.parseFloat(response.data.moveset.surpriseMove.moveBuff, 10),
                        pMoveKey: null
            })
        })
    }, [setDefender,setAttacker])

    function PlayerAvatar() {
        const avatarHead = attacker.headImage
        const avatarTorso = attacker.torsoImage
        const avatarArms = attacker.armsImage
        const avatarWaist = attacker.waistImage
        const avatarLegs = attacker.legsImage
        return (
            <div className='battle-avatar-window'>
                <img src={avatarHead} className='battle-body-part battle-body-head' />
                <img src={avatarTorso} className='battle-body-part battle-body-torso' />
                <img src={avatarArms} className='battle-body-part battle-body-arms' />
                <img src={avatarWaist} className='battle-body-part battle-body-waist' />
                <img src={avatarLegs} className='battle-body-part battle-body-legs' />
            </div>
        );
    }
    function OpponentAvatar() {
        const avatarHead = defender.headImage
        const avatarTorso = defender.torsoImage
        const avatarArms = defender.armsImage
        const avatarWaist = defender.waistImage
        const avatarLegs = defender.legsImage
        return (
            <div className='opponent-avatar-window'>
                <img src={avatarHead} className='battle-body-part battle-body-head' />
                <img src={avatarTorso} className='battle-body-part battle-body-torso' />
                <img src={avatarArms} className='battle-body-part battle-body-arms' />
                <img src={avatarWaist} className='battle-body-part battle-body-waist' />
                <img src={avatarLegs} className='battle-body-part battle-body-legs' />
            </div>
        );
    }
    function startBattle() {
        console.log(defender.userId,defender.userName);
        let params = {
            humanPlayer: attacker.userId,
            opponent: defender.userId
        }
        console.log("Prepare for battle, ",{params});
        axios.get('http://localhost:8080/battle',{params}).then(response => {
            JSON.stringify(localStorage.setItem("battleInfo",response.data));
            setNowBattle({
                battleId: response.data.battleId,
                    attacker: response.data.attacker,
                    attackerHP: Number.parseFloat(response.data.attackerHP),
                    attackerSurpriseCount: Number.parseInt(response.data.attackerSurpriseCount,10),
                    defender: response.data.defender,
                    defenderHP: Number.parseFloat(response.data.defenderHP),
                    defenderSurpriseCount: Number.parseInt(response.data.defenderSurpriseCount,10),
                resultId: Number.parseInt(response.data.result.resultId),
                    winner: response.data.result.winner,
                    roundCount: Number.parseInt(response.data.result.roundCount,10),
                    roundList: response.data.result.roundList,
                    formula: response.data.result.formula
            })
        }, [setNowBattle])
    }
    
    function chooseChi() {
        const chiURL = "http://localhost:8080/chooseChi";
        console.log("Round is now",nowBattle.roundCount);
        axios.post(chiURL,nowBattle).then(response => {
            console.log(attacker.userName, " attacks with ", attacker.cMoveName, "!");
            localStorage.setItem("battleInfo",JSON.stringify(response.data));
            setNowBattle({
                battleId: response.data.battleId,
                    attacker: response.data.attacker,
                    attackerHP: Number.parseFloat(response.data.attackerHP),
                    attackerSurpriseCount: Number.parseInt(response.data.attackerSurpriseCount,10),
                    defender: response.data.defender,
                    defenderHP: Number.parseFloat(response.data.defenderHP),
                    defenderSurpriseCount: Number.parseInt(response.data.defenderSurpriseCount,10),
                resultId: Number.parseInt(response.data.result.resultId),
                    winner: response.data.result.winner,
                    roundCount: Number.parseInt(response.data.result.roundCount,10),
                    roundList: response.data.result.roundList,
                    formula: response.data.result.formula
            }, [setNowBattle])
            if(response.data.attackerSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setADisable(true);
            } else {
                setADisable(false);
            }
            if(response.data.defenderSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setDDisable(true);
            } else {
                setDDisable(false);
            }
            console.log(JSON.parse(localStorage.getItem("battleInfo")));
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        });
    }

    function chooseKen() {
        const kenURL = "http://localhost:8080/chooseKen";
        console.log("Round is now",nowBattle.roundCount);
        axios.post(kenURL,nowBattle).then(response => {
            console.log(attacker.userName, " attacks with ", attacker.kMoveName, "!");
            localStorage.setItem("battleInfo",JSON.stringify(response.data));
            setNowBattle({
                battleId: response.data.battleId,
                    attacker: response.data.attacker,
                    attackerHP: Number.parseFloat(response.data.attackerHP),
                    attackerSurpriseCount: Number.parseInt(response.data.attackerSurpriseCount,10),
                    defender: response.data.defender,
                    defenderHP: Number.parseFloat(response.data.defenderHP),
                    defenderSurpriseCount: Number.parseInt(response.data.defenderSurpriseCount,10),
                resultId: Number.parseInt(response.data.result.resultId),
                    winner: response.data.result.winner,
                    roundCount: Number.parseInt(response.data.result.roundCount,10),
                    roundList: response.data.result.roundList,
                    formula: response.data.result.formula
            }, [setNowBattle])
            if(response.data.attackerSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setADisable(true);
            } else {
                setADisable(false);
            }
            if(response.data.defenderSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setDDisable(true);
            } else {
                setDDisable(false);
            }
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        });
    }

    function chooseSei() {

        const seiURL = "http://localhost:8080/chooseSei";
        console.log("Round is now",nowBattle.roundCount);
        axios.post(seiURL,nowBattle).then(response => {
            console.log(attacker.userName, " attacks with ", attacker.sMoveName, "!");
            localStorage.setItem("battleInfo",JSON.stringify(response.data));
            setNowBattle({
                battleId: response.data.battleId,
                    attacker: response.data.attacker,
                    attackerHP: Number.parseFloat(response.data.attackerHP),
                    attackerSurpriseCount: Number.parseInt(response.data.attackerSurpriseCount,10),
                    defender: response.data.defender,
                    defenderHP: Number.parseFloat(response.data.defenderHP),
                    defenderSurpriseCount: Number.parseInt(response.data.defenderSurpriseCount,10),
                resultId: Number.parseInt(response.data.result.resultId),
                    winner: response.data.result.winner,
                    roundCount: Number.parseInt(response.data.result.roundCount,10),
                    roundList: response.data.result.roundList,
                    formula: response.data.result.formula
            }, [setNowBattle])
            if(response.data.attackerSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setADisable(true);
            } else {
                setADisable(false);
            }
            if(response.data.defenderSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setDDisable(true);
            } else {
                setDDisable(false);
            }
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        });
    }

    function chooseSurprise() {
        const surpriseURL = "http://localhost:8080/chooseSurprise";
        console.log("Round is now",nowBattle.roundCount);
        axios.post(surpriseURL,nowBattle).then(response => {
            console.log(attacker.userName, " attacks with ", attacker.pMoveName, "!");
            localStorage.setItem("battleInfo",JSON.stringify(response.data));
            setNowBattle({
                battleId: response.data.battleId,
                    attacker: response.data.attacker,
                    attackerHP: Number.parseFloat(response.data.attackerHP),
                    attackerSurpriseCount: Number.parseInt(response.data.attackerSurpriseCount,10),
                    defender: response.data.defender,
                    defenderHP: Number.parseFloat(response.data.defenderHP),
                    defenderSurpriseCount: Number.parseInt(response.data.defenderSurpriseCount,10),
                resultId: Number.parseInt(response.data.result.resultId),
                    winner: response.data.result.winner,
                    roundCount: Number.parseInt(response.data.result.roundCount,10),
                    roundList: response.data.result.roundList,
                    formula: response.data.result.formula
            }, [setNowBattle])
            if(response.data.attackerSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setADisable(true);
            } else {
                setADisable(false);
            }
            if(response.data.defenderSurpriseCount != 0 || response.data.result.formula == "SHURYO") {
                setDDisable(true);
            } else {
                setDDisable(false);
            }
            if(response.data.result.formula == "SHURYO") {
                setEndBattle(true);
            }
        }).catch(error => {
            console.log("in the future add logic to navigate to an error page")
        });
    }
    const [aDisable, setADisable] = useState(false)
    const [dDisable, setDDisable] = useState(false)
    const [endBattle, setEndBattle] = useState(false)

    return(
        <div className="playableScreen">
            <PlayerAvatar />
            <form className='choose-move'>
                <table>
                    <tr>
                        <td><img src={hPIcon} className='battle-icon' /></td><td>Hit Points:</td><td>{nowBattle.attackerHP}</td><td>of</td><td>{attacker.totalHit}</td>
                    </tr>
                    <tr>
                        <td><img src={chiseiIcon} className='battle-icon' /></td><td>Chisei</td><td><button type="button" name="chi" value={attacker.cMoveId} onClick={chooseChi} disabled={endBattle} >{attacker.cMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={kenIcon} className='battle-icon' /></td><td>Ken</td><td><button type="button" name="ken" value={attacker.kMoveId} onClick={chooseKen} disabled={endBattle} >{attacker.kMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={seishinIcon} className='battle-icon' /></td><td>Seishin</td><td><button type="button" name="sei" value={attacker.sMoveId} onClick={chooseSei} disabled={endBattle} >{attacker.sMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={surpriseIcon} className='battle-icon' /></td><td>Surprise</td><td><button type="button" name="tohi" value={attacker.pMoveId} onClick={chooseSurprise} disabled={aDisable} >{attacker.pMoveName}</button></td>
                    </tr>
                </table>
            </form>
            <div>
                <h3>Round: {nowBattle.roundCount}</h3>
                <h3>Formula: {nowBattle.formula}</h3>
                <button className="btn btn-outline-success fight-begin" type="button" onClick={startBattle}>Begin the Fight?</button>
            </div>
            <OpponentAvatar />
            <form className='opponent-move'>
                <table>
                    <tr>
                        <td><img src={hPIcon} className='battle-icon' /></td><td>Hit Points:</td><td>{nowBattle.defenderHP}</td><td>of</td><td>{defender.totalHit}</td>
                    </tr>
                    <tr>
                        <td><img src={chiseiIcon} className='battle-icon' /></td><td>Chisei</td><td><button type="button" name="chiMove" value={defender.cMoveId} disabled={endBattle}>{defender.cMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={kenIcon} className='battle-icon' /></td><td>Ken</td><td><button type="button" name="kenMove" value={defender.kMoveId} disabled={endBattle}>{defender.kMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={seishinIcon} className='battle-icon' /></td><td>Seishin</td><td><button type="button" name="seiMove" value={defender.sMoveId} disabled={endBattle}>{defender.sMoveName}</button></td>
                    </tr>
                    <tr>
                        <td><img src={surpriseIcon} className='battle-icon' /></td><td>Surprise</td><td><button type="button" name="surpriseMove" value={defender.pMoveId} disabled={dDisable}>{defender.pMoveName}</button></td>
                    </tr>
                </table>
            </form>
        </div>
    );
}
export default Arena;